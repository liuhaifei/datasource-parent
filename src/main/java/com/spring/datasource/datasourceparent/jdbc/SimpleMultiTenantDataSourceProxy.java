package com.spring.datasource.datasourceparent.jdbc;

import com.spring.datasource.datasourceparent.util.MultiTenantStrategy;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName SimpleMultiTenantDataSourceProxy
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/19 15:35
 * @Version 1.0
 **/
public class SimpleMultiTenantDataSourceProxy extends AbstractMultiTenantDataSourceProxy {
    private MultiTenantStrategy multiTenantStrategy=MultiTenantStrategy.NONE;

    public SimpleMultiTenantDataSourceProxy(){}
    public SimpleMultiTenantDataSourceProxy(DataSource targetDataSource){super(targetDataSource);}
    public SimpleMultiTenantDataSourceProxy(DataSource targetDataSource,MultiTenantStrategy multiTenantStrategy){
        super(targetDataSource);
        this.multiTenantStrategy=multiTenantStrategy;
    }

    public MultiTenantStrategy getMultiTenantStrategy() {
        return multiTenantStrategy;
    }

    public void setMultiTenantStrategy(MultiTenantStrategy multiTenantStrategy) {
        this.multiTenantStrategy = multiTenantStrategy;
    }

    @Override
    protected Connection bindTenant(Connection connection, String tenant) throws SQLException {
        if(!StringUtils.isEmpty(tenant)){
            switch (multiTenantStrategy){
                case SCHEMA:connection.setSchema(tenant);break;
                case CATALOG:connection.setCatalog(tenant);break;
                case DATABASE:connection.prepareStatement("USE"+tenant).execute();break;
                case NONE:break;
                default:break;
            }
        }
        return connection;
    }
}

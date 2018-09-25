package com.spring.datasource.datasourceparent.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName AbstractMultiTenantDataSourceProxy
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/19 15:36
 * @Version 1.0
 **/
public abstract class AbstractMultiTenantDataSourceProxy extends LazyConnectionDataSourceProxy{


    public AbstractMultiTenantDataSourceProxy(){}
    public AbstractMultiTenantDataSourceProxy(DataSource targetDataSource){
        super(targetDataSource);
    }

    @Autowired(required = false)
    private TenantAware tenantAware;

    public TenantAware getTenantAware() {
        return tenantAware;
    }

    public void setTenantAware(TenantAware tenantAware) {
        this.tenantAware = tenantAware;
    }

    @Override
    public Connection getConnection() throws SQLException {
        String tenant=tenant();
        Connection connection=targetDataSource().getConnection();
        return tryBindTenant(connection,tenant);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        String tenant=tenant();
        Connection connection=targetDataSource().getConnection(username,password);
        return tryBindTenant(connection,tenant);
    }


    protected String tenant(){
        if(tenantAware!=null){
            return tenantAware.currentTenant();
        }
        return null;
    }
    protected Connection tryBindTenant(Connection connection,String tenant) throws SQLException{
        try {
          return  bindTenant(connection,tenant);
        }catch (Throwable throwable){
            connection.close();
            throw throwable;
        }
    }

    protected abstract Connection bindTenant(Connection connection, String tenant) throws SQLException;
    protected DataSource targetDataSource(){return super.getTargetDataSource();}
}

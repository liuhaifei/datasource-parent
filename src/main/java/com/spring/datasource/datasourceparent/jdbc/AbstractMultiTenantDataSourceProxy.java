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

    @Override
    public Connection getConnection() throws SQLException {
        return super.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return super.getConnection(username, password);
    }
}

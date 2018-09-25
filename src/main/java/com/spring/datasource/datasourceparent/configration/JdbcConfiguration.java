package com.spring.datasource.datasourceparent.configration;

import com.spring.datasource.datasourceparent.jdbc.SimpleMultiTenantDataSourceProxy;
import com.spring.datasource.datasourceparent.jdbc.TenantAware;
import com.spring.datasource.datasourceparent.util.MultiTenantStrategy;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

/**
 * @ClassName JdbcConfiguration
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/19 15:10
 * @Version 1.0
 **/
@Configuration
public class JdbcConfiguration {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    public DataSource dataSource(DataSourceProperties properties){

        DataSource dataSource=properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        return new SimpleMultiTenantDataSourceProxy(dataSource, MultiTenantStrategy.CATALOG);
    }


    @Bean
    public TenantAware tenantAware(){
        return () -> SessionUtils.getTenantId();
    }
}

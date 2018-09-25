package com.spring.datasource.datasourceparent.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName MvcConfiguration
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/25 10:55
 * @Version 1.0
 **/
@Configuration
public class MvcConfiguration extends WebMvcConfigurationSupport {

    @Bean
    public Interceptor interceptor(){
        return new Interceptor();
    }
    @Autowired
    private Interceptor interceptor;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor);
    }
}

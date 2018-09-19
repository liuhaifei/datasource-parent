package com.spring.datasource.datasourceparent.jdbc;

import com.spring.datasource.datasourceparent.configration.SessionUtils;
import org.springframework.stereotype.Component;

/**
 * @ClassName TenantAware
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/19 15:19
 * @Version 1.0
 **/

public interface TenantAware  {

    String currentTenant();
}

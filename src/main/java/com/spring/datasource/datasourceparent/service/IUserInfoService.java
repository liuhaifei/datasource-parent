package com.spring.datasource.datasourceparent.service;

import com.spring.datasource.datasourceparent.domain.UserInfo;

/**
 * @ClassName IUserInfoService
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/18 16:57
 * @Version 1.0
 **/
public interface IUserInfoService {

    UserInfo findOne(Integer userId);
}

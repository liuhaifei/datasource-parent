package com.spring.datasource.datasourceparent.service.impl;

import com.spring.datasource.datasourceparent.domain.UserInfo;
import com.spring.datasource.datasourceparent.mapper.UserInfoMapper;
import com.spring.datasource.datasourceparent.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserInfoServiceImpl
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/18 16:57
 * @Version 1.0
 **/
@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findOne(Integer userId) {
        return userInfoMapper.findOne(userId);
    }
}

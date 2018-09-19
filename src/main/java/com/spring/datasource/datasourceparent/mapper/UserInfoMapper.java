package com.spring.datasource.datasourceparent.mapper;

import com.spring.datasource.datasourceparent.domain.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserInfoMapper
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/18 16:52
 * @Version 1.0
 **/

public interface UserInfoMapper {

    UserInfo findOne(Integer userId);
}

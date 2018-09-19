package com.spring.datasource.datasourceparent.controller;

import com.spring.datasource.datasourceparent.domain.UserInfo;
import com.spring.datasource.datasourceparent.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserInfoController
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/18 16:59
 * @Version 1.0
 **/
@RestController
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;


    @GetMapping("/get/userInfo")
    public UserInfo getUserInfo(@RequestParam(name = "userId") Integer userId){
        try {
            return userInfoService.findOne(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

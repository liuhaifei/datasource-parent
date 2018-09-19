package com.spring.datasource.datasourceparent.domain;

import java.math.BigDecimal;

/**
 * @ClassName UserInfo
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/18 16:49
 * @Version 1.0
 **/
public class UserInfo {

    private Integer userId;
    private String userName;
    private String password;
    private String account;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

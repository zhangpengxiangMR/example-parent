package com.pykj.springmvc.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Person {

    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @Size(min = 6,max = 12,message = "密码为6-12位")
    private String password;

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
}

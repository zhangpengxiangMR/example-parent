package com.pykj.ykz.chapter4.aspect.validator.impl;


import com.pykj.ykz.chapter4.aspect.pojo.User;
import com.pykj.ykz.chapter4.aspect.validator.UserValidator;

public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口：" + UserValidator.class.getSimpleName());
        return user.getId() != null;
    }

}

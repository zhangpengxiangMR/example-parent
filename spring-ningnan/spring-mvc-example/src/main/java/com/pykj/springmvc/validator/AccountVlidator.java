package com.pykj.springmvc.validator;

import com.pykj.springmvc.entity.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AccountVlidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return Account.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name",null,"用户名不能为空");
        ValidationUtils.rejectIfEmpty(errors,"password",null,"密码不能为空");
    }
}

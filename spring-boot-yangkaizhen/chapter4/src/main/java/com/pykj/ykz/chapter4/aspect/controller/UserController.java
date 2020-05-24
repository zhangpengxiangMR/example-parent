package com.pykj.ykz.chapter4.aspect.controller;

import com.pykj.ykz.chapter4.aspect.pojo.Person;
import com.pykj.ykz.chapter4.aspect.pojo.User;
import com.pykj.ykz.chapter4.aspect.service.UserService;
import com.pykj.ykz.chapter4.aspect.validator.UserValidator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/21 21:56
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    /*private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }*/

    @RequestMapping("/print")
    public User printUser(Long id,String userName,String note){
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        userService.printUser(user);
        return user;
    }

    @RequestMapping("/vp")
    public Person validateAndPrint(Long id, String userName, String note){
        User user = new User();
        user.setId(id);
        user.setUserName(userName);
        user.setNote(note);
        UserValidator userValidator = (UserValidator)userService;
        Person person = new Person();
        if(userValidator.validate(user)){
            person = userService.printUser(user);
        }
        return person;
    }


}

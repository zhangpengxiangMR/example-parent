package com.pykj.example.one.web;

import com.pykj.example.one.domain.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

    @RequestMapping("/getUser")
    public User getUser() {
        User user=new User();
        user.setName("小明");
        user.setAge(12);
        user.setPass("123456");
        return user;
    }

    @RequestMapping(value = "/getUsers", method= RequestMethod.POST)
    public List<User> getUsers() {
        System.out.println("====================中国人");
        List<User> users=new ArrayList<User>();
        User user1=new User();
        user1.setName("neo");
        user1.setAge(30);
        user1.setPass("neo123");
        users.add(user1);
        User user2=new User();
        user2.setName("小明");
        user2.setAge(12);
        user2.setPass("123456");
        users.add(user2);
        return users;
    }

    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result) {
        System.out.println("user:"+user);
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode() + "======****&&&&&" + error.getDefaultMessage());
            }
        }
    }

}

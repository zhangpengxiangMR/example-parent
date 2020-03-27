package com.pykj.exemple.controller;

import com.pykj.exemple.entity.UserMap;
import com.pykj.exemple.entity.Users;
import com.pykj.exemple.entity.UsersList;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/data")
public class DataBindHandler {

    @RequestMapping("/baseType")
    @ResponseBody
    public String baseType(int i ){
        System.out.println("进入baseType()方法");
        return i + "";
    }

    @RequestMapping("/packageType")
    @ResponseBody
    public String packageType(@RequestParam(value = "num",required = false,defaultValue = "10000") Integer i){
        System.out.println("进入packageType()方法");
        return i + "";
    }

    @RequestMapping("/array")
    public String array(String[] name){
        String str = Arrays.toString(name);
        System.out.println("进入arry()方法,返回值为" +str);
        return str;
    }

    @RequestMapping("/list")
    public String list(UsersList usersList){
        StringBuilder str = new StringBuilder();
        for (Users user: usersList.getUsers()) {
            str.append(user);
        }
        return str.toString();
    }

    @RequestMapping("/map")
    public String map(UserMap userMap){
        StringBuilder builder = new StringBuilder();
        for (String key:userMap.getUsers().keySet()) {
            Users users = userMap.getUsers().get(key);
            builder.append(users);
        }
        return builder.toString();
    }

    @RequestMapping("/json")
    public Users json(@RequestBody Users users){
        System.out.println(users);
        users.setId(11);
        users.setName("王五");
        return users;
    }


}

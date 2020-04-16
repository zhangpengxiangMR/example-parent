package com.pykj.springmvc.controller;

import com.pykj.springmvc.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping( value = "/index")
public class HelloHandler {

    @RequestMapping( value = "/index",method = RequestMethod.GET)
    public String index(@RequestParam("name") String name,@RequestParam("id") int id){
        System.out.println("执行了indaex....");
        System.out.println("输出结果========name:" + name + "id:" + id);
        return "index";
    }

    @RequestMapping("/rest/{name}/{id}")
    public String rest(@PathVariable("name") String name,@PathVariable("id") int age){
        System.out.println("执行了rest....");
        System.out.println("输出结果========name:" + name + "age:" + age);
        return "index";
    }

    @RequestMapping("/cookie")
    public String cookie(@CookieValue("JSESSIONID") String id){
        System.out.println("执行了cookie....");
        System.out.println("输出结果========JSESSIONID:" + id);
        return "index";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Users users){
        System.out.println("执行了save....");
        System.out.println("输出结果========:" + users);
        return "index";
    }

    /**
     * 转发
     * @return
     */
    @RequestMapping("/forward")
    public String forward(){
        System.out.println("转发forward");
        return "forward:/index.jsp";
    }

    /**
     * 重定向
     * @return
     */
    @RequestMapping("/redirect")
    public String  redirect(){
        System.out.println("重定向redirect");
        return "redirect:/index.jsp";
    }


}

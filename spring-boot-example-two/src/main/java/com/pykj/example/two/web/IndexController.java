package com.pykj.example.two.web;

import com.alibaba.druid.util.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("index")
    public String index(){
        return "spring-boot-example-one";
    }

}

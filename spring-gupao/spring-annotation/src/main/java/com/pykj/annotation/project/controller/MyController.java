package com.pykj.annotation.project.controller;

import com.pykj.annotation.project.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/13 18:14
 */
@Controller
public class MyController {

    @Autowired
    private MyService myService;

}

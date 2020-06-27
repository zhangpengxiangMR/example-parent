package com.pykj.ykz.chapter4.service.impl;

import com.pykj.ykz.chapter4.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if (name == null || name.trim().equals("")) {
            throw new RuntimeException("参数异常");
        }
        System.out.println("hello" + name);
    }
}

package com.pykj.v1.demo.service.impl;

import com.pykj.v1.mvcframework.annotation.PYService;
import com.pykj.v1.demo.service.IDemoService;

/**
 * 核心业务逻辑
 */
@PYService
public class DemoService implements IDemoService {

    @Override
    public String get(String name) {
        return "My name is " + name + ",from service.";
    }

}

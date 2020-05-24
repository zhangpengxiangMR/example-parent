package com.pykj.ykz.chapter4.service.impl;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/4/21 15:21
 */
public class HelloTest {

    public void sayHello(String name) {
        if(name == null || name.trim().equals("")){
            throw new RuntimeException("参数异常");
        }
        System.out.println("hello" + name);
    }
}

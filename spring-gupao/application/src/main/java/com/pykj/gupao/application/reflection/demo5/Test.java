package com.pykj.gupao.application.reflection.demo5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: TODO
 * @author: zhangpengxiang
 * @time: 2020/6/27 22:46
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("Spring-ioc.xml");
        A a = (A)applicationContext.getBean("a");
        B b = (B)applicationContext.getBean("b");
        C c = (C)applicationContext.getBean("c");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}

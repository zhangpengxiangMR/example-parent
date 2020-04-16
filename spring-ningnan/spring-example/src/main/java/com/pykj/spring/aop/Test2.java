package com.pykj.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Cal proxy = (Cal) applicationContext.getBean("calImpl");
        proxy.add(1,1);
        proxy.sub(2,1);
        proxy.mul(2,3);
        proxy.div(6,0);
    }

}

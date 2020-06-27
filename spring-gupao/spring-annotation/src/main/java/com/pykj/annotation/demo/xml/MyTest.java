package com.pykj.annotation.demo.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    /**
     * 通过ClassPathCmlApplicationContext读取application.xml
     * context.getbean("person123")，通过在xml中定义的id，获取对应的实例化Bean
     * 如果不写id="person123"，那么默认类名首字母小写获取
     */
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Object person = context.getBean("person123");
        System.out.println(person);

    }

}

package com.pykj.annotation.demo.annotation.configure.configuration;

import com.pykj.annotation.project.entity.MyPerson;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试configuration
 */
public class MyTest {


    /**
     * 首先取出方法名称作为Bean的name
     * 优先取出自定义的Bean的name
     */
    @Test
    public void test() {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Object person1 = context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person1 == person2);


        MyPerson person = context.getBean(MyPerson.class);
        System.out.println(person);

    }

}

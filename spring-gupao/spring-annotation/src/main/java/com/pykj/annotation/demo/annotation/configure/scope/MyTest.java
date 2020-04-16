package com.pykj.annotation.demo.annotation.configure.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: @Scope测试类
 * @author: zhangpengxiang
 * @time: 2020/4/14 23:03
 */
public class MyTest {

    @Test
    public void test(){

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Object person1= context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person1 == person2);


    }

}

package com.pykj.annotation.demo.annotation.configure.lazy;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: @Lazy测试类
 * @author: zhangpengxiang
 * @time: 2020/4/14 17:00
 */
public class MyTest {

    @Test
    public void test(){

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("IoC容器创建完成");
        context.getBean("person");


    }

}

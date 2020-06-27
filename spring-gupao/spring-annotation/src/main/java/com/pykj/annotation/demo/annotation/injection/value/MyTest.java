package com.pykj.annotation.demo.annotation.injection.value;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: @value测试类
 * @author: zhangpengxiang
 * @time: 2020/4/15 23:19
 */
public class MyTest {

    @Test
    public void test() {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println(context.getBean("bird"));

    }

}

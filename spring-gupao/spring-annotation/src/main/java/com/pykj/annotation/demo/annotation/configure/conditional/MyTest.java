package com.pykj.annotation.demo.annotation.configure.conditional;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: @conditional测试类
 * @author: zhangpengxiang
 * @time: 2020/4/14 23:03
 */
public class MyTest {

    @Test
    public void test() {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);


    }

}

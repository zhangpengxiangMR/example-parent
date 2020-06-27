package com.pykj.annotation.demo.annotation.configure.imports;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @description: @Import测试类
 * @author: zhangpengxiang
 * @time: 2020/4/15 11:50
 */
public class MyTest {

    @Test
    public void test() {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        System.out.println(context.getBean("monkey").getClass());

        System.out.println("-----------------华丽丽的分隔符-------------------------");

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames)
                .replaceAll("\\[|\\]", "")
                .replaceAll("\\, ", "\n"));

    }

}

package com.pykj.annotation.demo.annotation.injection.primary;

import com.pykj.annotation.project.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class MyTest {

    @Test
    public void test(){

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames)
                .replaceAll("\\[|\\]","")
                .replaceAll("\\, ","\n"));
        MyService bean = context.getBean(MyService.class);
        System.out.println(bean.myDao.toString());


    }

}

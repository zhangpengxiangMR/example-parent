package com.pykj.annotation.demo.annotation.injection.qualifier;

import com.pykj.annotation.project.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyTest {

    @Test
    public void test(){

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        MyService bean = context.getBean(MyService.class);
        System.out.println(bean.myDao.toString());


    }

}

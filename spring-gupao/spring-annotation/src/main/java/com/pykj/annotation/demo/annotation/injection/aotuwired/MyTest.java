package com.pykj.annotation.demo.annotation.injection.aotuwired;

import com.pykj.annotation.project.controller.MyController;
import com.pykj.annotation.project.dao.MyDao;
import com.pykj.annotation.project.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MyTest {

    @Test
    public void test(){

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        MyController controller = context.getBean(MyController.class);
        MyService service = context.getBean(MyService.class);
        MyDao dao = context.getBean(MyDao.class);

        service.print();
        System.out.println(dao);




    }

}

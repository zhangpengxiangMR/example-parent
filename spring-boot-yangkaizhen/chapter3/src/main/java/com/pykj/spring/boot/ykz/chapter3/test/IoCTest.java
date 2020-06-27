package com.pykj.spring.boot.ykz.chapter3.test;

import com.pykj.spring.boot.ykz.chapter3.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCTest {

    private static Logger logger = LoggerFactory.getLogger(IoCTest.class);

    /**
     * 代码中将java配置文件AppConfig传递给AnnotationConfigApplicationContext的构造方法，这样它就能够读取配置了，
     * 然后将配置中的Bean装配到IoC容器中，于是可以使用getBean方法获取对应的POJO，
     *
     * @param args
     */
    public static void main(String[] args) {
       /* ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        User user1 = (User)ctx.getBean("user");
        logger.info(user.toString());
        logger.info(user1.toString());
        System.out.println(user == user1);
        System.out.println(user.equals(user1));
       *//* UserService userService = ctx.getBean(UserService.class);
        userService.printUser(user);*//*
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource);*/

        /*ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = ctx.getBean(BussinessPerson.class);
        person.service();*/

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //ctx.close();

    }

}

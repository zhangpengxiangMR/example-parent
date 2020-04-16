package com.pykj.annotation.demo.annotation.configure.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description: 声明周期测试类
 * @author: zhangpengxiang
 * @time: 2020/4/14 17:00
 */
public class MyTest {

    @Test
    public void test(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        System.out.println("IoC容器创建完成");
        //MyCar myCar = (MyCar)context.getBean("myCar");
        //myCar.run();
        //System.out.println(context.getBean("myTrain"));
        context.close();
    }

}

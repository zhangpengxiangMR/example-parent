package com.pykj.annotation.demo.annotation.configure.conditional;


import com.pykj.annotation.project.entity.MyPerson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @description: @conditional
 * @author: zhangpengxiang
 * @time: 2020/4/14 23:03
 */
@Configuration
public class MyConfig {

    @Conditional(WinConditional.class)
    @Bean
    public MyPerson tom(){
        System.out.println("将对象tom添加到IoC容器中");
        return new MyPerson("tom",19);
    }

    @Conditional(WinConditional.class)
    @Bean
    public MyPerson mic(){
        System.out.println("将对象mic添加到IoC容器中");
        return new MyPerson("mic",18);
    }

    @Conditional(LinuxConditional.class)
    @Bean
    public MyPerson james(){
        System.out.println("将对象james添加到IoC容器中");
        return new MyPerson("james",17);
    }

}

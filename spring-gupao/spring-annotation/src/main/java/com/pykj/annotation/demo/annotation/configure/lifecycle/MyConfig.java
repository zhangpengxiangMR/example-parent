package com.pykj.annotation.demo.annotation.configure.lifecycle;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 声明周期
 * @author: zhangpengxiang
 * @time: 2020/4/14 17:00
 */
@Configuration
@ComponentScans({@ComponentScan("com.pykj.annotation.project"), @ComponentScan("com.pykj.annotation.demo.annotation.configure.lifecycle")})
public class MyConfig {

   /* @Bean(initMethod = "addOil",destroyMethod = "close")
    public MyCar myCar(){
        return new MyCar();
    }*/

}

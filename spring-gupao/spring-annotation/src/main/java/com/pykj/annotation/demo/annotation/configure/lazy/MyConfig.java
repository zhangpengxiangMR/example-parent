package com.pykj.annotation.demo.annotation.configure.lazy;


import com.pykj.annotation.project.entity.MyPerson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @description: @Lazy
 * @author: zhangpengxiang
 * @time: 2020/4/14 17:00
 */
@Configuration
public class MyConfig {


    /**
     * 默认是非延迟加载
     * 延迟加载，懒加载只针对单例的Bean起作用
     * 默认容器启动时不创建对象，调用对象的功能时才会创建对象，这就是延迟加载
     */
    @Lazy
    @Bean(value = "person")
    public MyPerson person1() {
        System.out.println("将对象添加到IoC容器中");
        return new MyPerson("张鹏祥", 19);
    }

}

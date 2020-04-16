package com.pykj.annotation.demo.annotation.configure.scope;


import com.pykj.annotation.project.entity.MyPerson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @description: @Scope
 * @author: zhangpengxiang
 * @time: 2020/4/14 23:03
 */
@Configuration
public class MyConfig {

    /**
     * @Scope的value
     * prototype    原型，多例
     * singleton    单例
     * request      主要应用与web模块，同一次请求只创建一个实例
     * session      主要应用于WEB模块，同一个session只创建一个对象
     * @return
     */
    //@Scope(value = "prototype")
    @Scope(scopeName = "prototype")
    @Bean(value = "person")
    public MyPerson person1(){
        return new MyPerson("张鹏祥",19);
    }

}

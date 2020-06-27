package com.pykj.annotation.demo.annotation.configure.configuration;


import com.pykj.annotation.project.entity.MyPerson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean(value = "person")
    //@Bean
    public MyPerson person1() {
        return new MyPerson("张鹏祥", 19);
    }

}

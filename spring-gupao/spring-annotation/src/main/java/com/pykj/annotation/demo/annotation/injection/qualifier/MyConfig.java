package com.pykj.annotation.demo.annotation.injection.qualifier;


import com.pykj.annotation.project.dao.MyDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "com.pykj.annotation.project.controller",
        "com.pykj.annotation.project.service",
        "com.pykj.annotation.project.dao"}
)
public class MyConfig {

    @Bean
    public MyDao dao() {
        MyDao dao = new MyDao();
        dao.setFlag(2);
        return dao;
    }

}

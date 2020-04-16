package com.pykj.annotation.demo.annotation.injection.resource;


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
    public MyDao resourceDao() {
        MyDao dao = new MyDao();
        dao.setFlag(3);
        return dao;
    }

}

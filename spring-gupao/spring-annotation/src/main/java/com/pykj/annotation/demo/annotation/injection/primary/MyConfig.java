package com.pykj.annotation.demo.annotation.injection.primary;


import com.pykj.annotation.project.dao.MyDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({
        "com.pykj.annotation.project.controller",
        "com.pykj.annotation.project.service",
        "com.pykj.annotation.project.dao"}
)
public class MyConfig {

    @Primary
    @Bean
    public MyDao myDao() {
        MyDao dao = new MyDao();
        dao.setFlag(33);
        return dao;
    }

}

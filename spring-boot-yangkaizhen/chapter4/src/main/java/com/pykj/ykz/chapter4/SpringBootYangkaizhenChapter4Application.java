package com.pykj.ykz.chapter4;

import com.pykj.ykz.chapter4.aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.pykj.ykz.chapter4.aspect"})
public class SpringBootYangkaizhenChapter4Application {

    @Bean(name = "myAspect")
    public MyAspect initMyAspect(){
        return new MyAspect();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootYangkaizhenChapter4Application.class, args);
    }

}

package com.pykj.spring.boot.ykz.chapter3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pykj.spring.boot.ykz.chapter3.*"})
@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = false)
public class Chapter3Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter3Application.class, args);
    }
}

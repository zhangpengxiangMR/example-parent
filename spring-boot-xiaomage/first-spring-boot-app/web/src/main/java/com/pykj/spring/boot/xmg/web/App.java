package com.pykj.spring.boot.xmg.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication
 * 等价于
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        springApplication.run(args);
    }


}

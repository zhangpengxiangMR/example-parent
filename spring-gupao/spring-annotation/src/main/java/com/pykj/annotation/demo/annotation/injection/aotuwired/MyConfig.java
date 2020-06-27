package com.pykj.annotation.demo.annotation.injection.aotuwired;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "com.pykj.annotation.project.controller",
        "com.pykj.annotation.project.service",
        "com.pykj.annotation.project.dao"}
)
public class MyConfig {

}

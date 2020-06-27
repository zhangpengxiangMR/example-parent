package com.pykj.annotation.demo.annotation.injection.propertysource;


import com.pykj.annotation.project.entity.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @description: @Value
 * @author: zhangpengxiang
 * @time: 2020/4/15 23:19
 */
@Configuration
@PropertySource("classpath:values.properties")
public class MyConfig {

    @Bean
    public Bird bird() {
        return new Bird();
    }

}

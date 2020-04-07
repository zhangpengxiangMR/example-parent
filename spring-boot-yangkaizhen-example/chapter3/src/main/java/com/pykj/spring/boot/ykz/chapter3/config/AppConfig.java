package com.pykj.spring.boot.ykz.chapter3.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Configuration代表这个是一个java配置文件，Spring的容器会根据它来生成IoC容器去装配Bean
 * @Bean代表将initUser方法返回的POJO装配到IoC容器中，而其属性name定义这个Bean的名称，如果没有配置它，则将方法名称"initUser"作为Bean的名称保存到SpringIoC容器中
 *
 * @ComponentScan它会进行扫描，但是它指挥扫描类所在的当前及子包。
 * @ComponentScan("com.pykj.spring.boot.ykz.chapter3.*")
 * @ComponentScan(basePackages={"com.pykj.spring.boot.ykz.chapter3.entity"})
 * @ComponentScan(basePakageClasses={User.class})
 * excludeFilters = {@Filter (classes = UserService.class)}排除对应的类
 */
//@Configuration
//@ComponentScan(basePackages = {"com.pykj.spring.boot.ykz.chapter3.*"},lazyInit = true)
//@ComponentScan(basePackages = {"com.pykj.spring.boot.ykz.chapter3.*"})
public class AppConfig {

    /*@Bean(name = "user")
    public User initUser(){
        User user = new User();
        user.setId(1L);
        user.setUserName("user_name_1");
        user.setNote("note_1");
        return user;
    }*/

    @Bean(name = "dataSource")
    public DataSource getDevDataSource() {
        Properties props = new Properties();
        props.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        props.setProperty("url", "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&amp;characterEncoding=UTF-8");
        props.setProperty("username", "root");
        props.setProperty("password", "123456");
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }


}

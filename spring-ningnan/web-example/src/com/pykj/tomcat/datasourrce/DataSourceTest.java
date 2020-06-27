package com.pykj.tomcat.datasourrce;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

public class DataSourceTest {

    public static void main(String[] args) {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource("testc3p0");
            /*dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring_boot?useUnicode=true&characterEncoding=UTF-8");
            dataSource.setUser("root");
            dataSource.setPassword("zhang");
            //设置初始化连接个数
            dataSource.setInitialPoolSize(20);
            //设置最大连接数
            dataSource.setMaxPoolSize(40);
            //当连接对象不够时，再次申请的连接对象个数
            dataSource.setAcquireIncrement(5);
            //设置最小连接数
            dataSource.setMinPoolSize(2);*/
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

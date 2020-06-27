package com.pykj.spring.boot.ykz.chapter3.datasource;

import com.pykj.spring.boot.ykz.chapter3.condition.DatabaseConditional;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

@Component
public class DataSources {

    @Bean(name = "dataSource", destroyMethod = "close")
    @Conditional(value = DatabaseConditional.class)
    public DataSource getDataSource(
            @Value("${database.driverName}") String driverName,
            @Value("${database.url}") String url,
            @Value("${database.username}") String username,
            @Value("${database.password}") String password
    ) {
        Properties properties = new Properties();
        properties.setProperty("driver", driverName);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

}

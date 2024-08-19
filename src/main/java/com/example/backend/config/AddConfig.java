package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AddConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        // 设置JDBC驱动的类名
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        // 设置数据库连接的URL
        dataSource.setUrl("jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC");

        // 设置数据库的用户名
        dataSource.setUsername("your_username");

        // 设置数据库的密码
        dataSource.setPassword("your_password");
        System.out.println(dataSource);
        return dataSource;
    }
}

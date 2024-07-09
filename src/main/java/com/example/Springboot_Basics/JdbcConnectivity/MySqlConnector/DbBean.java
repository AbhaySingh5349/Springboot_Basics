package com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DbBean {
    @Bean
    public Connection connectToDB(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboot_basics_db", "root", "abhaysingh@20");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}

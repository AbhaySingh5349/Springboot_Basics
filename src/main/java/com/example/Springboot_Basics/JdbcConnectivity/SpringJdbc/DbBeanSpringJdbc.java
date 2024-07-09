package com.example.Springboot_Basics.JdbcConnectivity.SpringJdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class DbBeanSpringJdbc {
    @Bean("springJdbcConnectionBean")
    public DataSource dataSource(){
        log.info("springJdbcConnectionBean invoked");
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/springboot_basics_db")
                .username("root")
                .password("abhaysingh@20")
                .build();
    }
}
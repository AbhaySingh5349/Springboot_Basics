package com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person {
    private Integer id;
    private String name;
}

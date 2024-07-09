package com.example.Springboot_Basics.JdbcConnectivity;

import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model.Person;

import java.util.List;

public interface IPersonRepo {
    List<Person> getPersons();
    Integer createPerson(Person person);
}

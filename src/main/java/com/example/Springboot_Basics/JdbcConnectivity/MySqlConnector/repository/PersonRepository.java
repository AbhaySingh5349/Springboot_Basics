package com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.repository;

import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private final Connection connection;

    @Autowired
    public PersonRepository(Connection connection){
        this.connection = connection;
        createPersonTable();
    }

    private void createPersonTable(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springboot_basics_db", "root", "abhaysingh@20");

            connection.createStatement().execute("create table if not exists person (name varchar(20), id integer)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();

        try {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from person");

            while (resultSet.next()){
                Person p = new Person(resultSet.getInt("id"), resultSet.getString("name"));
                personList.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return personList;
    }

    public Integer createPerson(Person person){
        try {
            return connection.createStatement().executeUpdate("insert into person (id, name) values ('" + person.getId() + "', '" + person.getName() + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

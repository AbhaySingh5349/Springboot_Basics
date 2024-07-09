package com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.service;

import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model.Person;
import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons(){
        return personRepository.getPersons();
    }
}

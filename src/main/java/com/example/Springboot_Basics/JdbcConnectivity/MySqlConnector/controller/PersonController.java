package com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.controller;

import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model.Person;
import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.repository.PersonRepository;
import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService;
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @GetMapping("/persons")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @PostMapping("/person")
    public int createPerson(@RequestBody Person person) throws IllegalAccessException {
        if(person.getId() == null || person.getName() == null){
            throw new IllegalAccessException("Mandatory parameters are null");
        }
        return personRepository.createPerson(person);
    }
}

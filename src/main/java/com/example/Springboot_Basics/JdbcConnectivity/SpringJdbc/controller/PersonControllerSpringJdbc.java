package com.example.Springboot_Basics.JdbcConnectivity.SpringJdbc.controller;

import com.example.Springboot_Basics.JdbcConnectivity.IPersonRepo;
import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model.Person;
import com.example.Springboot_Basics.JdbcConnectivity.SpringJdbc.service.PersonServiceSpringJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("personControllerSpringJdbc")
public class PersonControllerSpringJdbc {
    private final PersonServiceSpringJdbc personService;
    private final IPersonRepo iPersonRepository;

    @Autowired
    public PersonControllerSpringJdbc(PersonServiceSpringJdbc personService, @Qualifier("personRepositorySpringJdbc") IPersonRepo iPersonRepository) {
        this.personService = personService;
        this.iPersonRepository = iPersonRepository;
    }

    @GetMapping("/personsSpringJdbc")
    public List<Person> getPersons(){
        return personService.getPersons();
    }

    @PostMapping("/personSpringJdbc")
    public int createPerson(@RequestBody Person person) throws IllegalAccessException {
        if(person.getId() == null || person.getName() == null){
            throw new IllegalAccessException("Mandatory parameters are null");
        }
        return iPersonRepository.createPerson(person);
    }
}

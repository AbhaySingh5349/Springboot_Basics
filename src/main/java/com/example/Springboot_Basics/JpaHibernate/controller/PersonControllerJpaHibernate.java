package com.example.Springboot_Basics.JpaHibernate.controller;

import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model.Person;
import com.example.Springboot_Basics.JpaHibernate.exception.CustomException;
import com.example.Springboot_Basics.JpaHibernate.service.JpaPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("personControllerJpaHibernate")
public class PersonControllerJpaHibernate {
    private final JpaPersonService jpaPersonService;

    @Autowired
    public PersonControllerJpaHibernate(@Qualifier("jpaPersonService") JpaPersonService jpaPersonService) {
        this.jpaPersonService = jpaPersonService;
    }

    @PostMapping("/personJpa")
    public int createPerson(@RequestBody Person person) throws IllegalAccessException, CustomException {
        if(person.getId() == null || person.getName() == null){
            throw new IllegalAccessException("Mandatory parameters are null");
        }
        return jpaPersonService.createPerson(person);
    }
}

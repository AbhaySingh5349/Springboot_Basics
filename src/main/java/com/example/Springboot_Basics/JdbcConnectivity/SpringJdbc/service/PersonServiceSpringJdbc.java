package com.example.Springboot_Basics.JdbcConnectivity.SpringJdbc.service;

import com.example.Springboot_Basics.JdbcConnectivity.IPersonRepo;
import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personServiceSpringJdbc")
public class PersonServiceSpringJdbc {
    private final IPersonRepo iPersonRepository;

    @Autowired
    public PersonServiceSpringJdbc(@Qualifier("personRepositorySpringJdbc") IPersonRepo iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    public List<Person> getPersons(){
        return iPersonRepository.getPersons();
    }
}

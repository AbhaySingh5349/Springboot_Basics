package com.example.Springboot_Basics.JpaHibernate.service;

import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model.Person;
import com.example.Springboot_Basics.JpaHibernate.exception.CustomException;
import com.example.Springboot_Basics.JpaHibernate.exception.TransactionException;
import com.example.Springboot_Basics.JpaHibernate.model.JpaPerson;
import com.example.Springboot_Basics.JpaHibernate.repository.JpaPersonRepo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("jpaPersonService")
@Slf4j
public class JpaPersonService {
    private final JpaPersonRepo jpaPersonRepo;

    public JpaPersonService(JpaPersonRepo jpaPersonRepo) {
        this.jpaPersonRepo = jpaPersonRepo;
    }

    @Transactional(rollbackOn = {CustomException.class})
    public Integer createPerson(Person person) throws CustomException {
        if(person.getName().equals("abhay")){
            throw new CustomException("invalid name");
        }

        JpaPerson addedPerson = jpaPersonRepo.save(new JpaPerson(person.getId(), person.getName()));
        log.info("jpa statement to create person invoked: {}", addedPerson);

        return 1;
    }
}

package com.example.Springboot_Basics.JdbcConnectivity.SpringJdbc.repository;

import com.example.Springboot_Basics.JdbcConnectivity.IPersonRepo;
import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("personRepositorySpringJdbc")
@Slf4j
public class PersonRepositorySpringJdbc implements IPersonRepo{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonRepositorySpringJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> getPersons() {
        log.info("springJdbcConnection Result Set for get person invoked");

        return jdbcTemplate.query("select * from person", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Person(rs.getInt("id"), rs.getString("name"));
            }
        });
    }

    @Override
    public Integer createPerson(Person person) {
        log.info("springJdbcConnection statement to create person invoked");

        String sql = "insert into person (id, name) values (?, ?)";
        return jdbcTemplate.update(sql, person.getId(), person.getName());
    }
}

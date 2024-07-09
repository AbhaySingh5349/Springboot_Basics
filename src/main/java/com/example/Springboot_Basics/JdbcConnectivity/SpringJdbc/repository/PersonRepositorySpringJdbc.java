package com.example.Springboot_Basics.JdbcConnectivity.SpringJdbc.repository;

import com.example.Springboot_Basics.JdbcConnectivity.IPersonRepo;
import com.example.Springboot_Basics.JdbcConnectivity.MySqlConnector.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("personRepositorySpringJdbc")
@Slf4j
public class PersonRepositorySpringJdbc implements IPersonRepo{
//    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public PersonRepositorySpringJdbc(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Person> getPersons() {
        log.info("springJdbcConnection Result Set for get person invoked");

        return namedParameterJdbcTemplate.query("select * from person", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Person(rs.getInt("id"), rs.getString("name"));
            }
        });
    }

    @Override
    public Integer createPerson(Person person) {
        log.info("springJdbcConnection statement to create person invoked");

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", person.getId());
        parameterSource.addValue("name", person.getName());

        String sql = "insert into person (id, name) values (:id, :name)";

        return namedParameterJdbcTemplate.update(sql, parameterSource);
    }
}

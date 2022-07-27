package com.tm.Tema8_SQL_JDBC.controller;

import com.tm.Tema8_SQL_JDBC.exceptions.DuplicateIdException;
import com.tm.Tema8_SQL_JDBC.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private JdbcTemplate jdbcTemplate;

    public PersonController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Person> personRowMapper = (rs, rowNum) -> {
        Person person = new Person();

        person.setId(rs.getInt("id"));
        person.setBirthDay(rs.getDate("birthDay"));
        person.setBirthPlace(rs.getString("birthPlace"));
        person.setName(rs.getString("name"));

        return person;
    };

    public void create(Person person){
        String sql = "INSERT INTO person(name, birthDay, birthPlace) VALUES(?,?,?)";

        int insert = jdbcTemplate.update(sql, person.getName(), person.getBirthDay(), person.getBirthPlace());

        if(insert == 1){
            logger.info("Inserted person: " + person);
        }
    }

    public void createWithID(Person person){
        String sql = "INSERT INTO person(id, name, birthDay, birthPlace) VALUES(?,?,?,?)";

        String sqlCheck = "SELECT * FROM person WHERE id = " + person.getId();
        List<Person> personsWithID = jdbcTemplate.query(sqlCheck, personRowMapper);

        try {
            if(personsWithID.isEmpty()){
                int insert = jdbcTemplate.update(sql, person.getId(), person.getName(), person.getBirthDay(), person.getBirthPlace());

                if(insert == 1){
                    logger.info("Inserted person: " + person);
                }
            }
            else{
                throw new DuplicateIdException(person.getId(), Person.class);
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    public void delete(Person person){
        String sql = "DELETE FROM person WHERE id = " + person.getId();
        logger.info("Deleted person: " + person);

        jdbcTemplate.execute(sql);
    }

    public List<Person> getPersonsBornBefore1990(){
        String sql = "SELECT * FROM person WHERE EXTRACT(YEAR FROM birthDay) < 1990";

        return jdbcTemplate.query(sql, personRowMapper);
    }

    public List<Person> getPersonsLivingInNatalCity(){
        String sql = "SELECT * FROM person p INNER JOIN address a ON p.id = a.ownerId AND p.birthPlace = a.city";

        return jdbcTemplate.query(sql, personRowMapper);
    }

    public List<Person> getPersonsLivingInSameCountry(int personId){
        String sqlCountry = "SELECT country FROM address WHERE ownerId = " + personId;
        String sqlCity = "SELECT city FROM address WHERE ownerId = " + personId;
        String sqlStreet = "SELECT street FROM address WHERE ownerId = " + personId;

        String sql = "SELECT * FROM person p INNER JOIN address a ON p.id = a.ownerId AND a.country IN (" + sqlCountry + ")";

        return jdbcTemplate.query(sql, personRowMapper);
    }

    public List<Person> getPersonsLivingInSameCity(int personId){
        String sqlCity = "SELECT city FROM address WHERE ownerId = " + personId;

        String sql = "SELECT * FROM person p INNER JOIN address a ON p.id = a.ownerId AND a.city IN (" + sqlCity + ")";

        return jdbcTemplate.query(sql, personRowMapper);
    }

    public List<Person> getPersonsLivingInSameStreet(int personId){
        String sqlStreet = "SELECT street FROM address WHERE ownerId = " + personId;

        String sql = "SELECT * FROM person p INNER JOIN address a ON p.id = a.ownerId AND a.street IN (" + sqlStreet + ")";

        return jdbcTemplate.query(sql, personRowMapper);
    }

    public List<Person> getPersonsSamePhoneServiceProvider(int personId){
        String sqlProvider = "SELECT serviceProvider FROM phoneNumber WHERE ownerId = " + personId;

        String sql = "SELECT * FROM person p INNER JOIN phoneNumber n ON p.id = n.ownerId AND n.serviceProvider IN (" + sqlProvider + ")";

        return jdbcTemplate.query(sql, personRowMapper);
    }
}

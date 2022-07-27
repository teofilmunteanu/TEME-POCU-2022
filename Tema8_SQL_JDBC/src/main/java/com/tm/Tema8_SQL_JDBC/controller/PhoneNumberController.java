package com.tm.Tema8_SQL_JDBC.controller;

import com.tm.Tema8_SQL_JDBC.exceptions.DuplicateIdException;
import com.tm.Tema8_SQL_JDBC.exceptions.DuplicatePhoneNrException;
import com.tm.Tema8_SQL_JDBC.model.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import java.util.List;

public class PhoneNumberController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private JdbcTemplate jdbcTemplate;

    public PhoneNumberController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<PhoneNumber> phoneNumberRowMapper = (rs, rowNum) -> {
        PhoneNumber phoneNumber = new PhoneNumber();

        phoneNumber.setId(rs.getInt("id"));
        phoneNumber.setNumber(rs.getString("number"));
        phoneNumber.setServiceProvider(rs.getString("serviceProvider"));
        phoneNumber.setOwnerId(rs.getInt("ownerId"));

        return phoneNumber;
    };

    public void create(PhoneNumber phoneNumber) {
        String sql = "INSERT INTO phoneNumber(number, serviceProvider, ownerId) VALUES(?,?,?)";

        int insert = jdbcTemplate.update(sql, phoneNumber.getNumber(), phoneNumber.getServiceProvider(), phoneNumber.getOwnerId());

        if (insert == 1) {
            logger.info("Inserted phone number: " + phoneNumber);
        }
    }

    public void createWithID(PhoneNumber phoneNumber) {
        String sql = "INSERT INTO phoneNumber(id, number, serviceProvider, ownerId) VALUES(?,?,?,?)";

        String sqlCheckDuplicateID = "SELECT * FROM phoneNumber WHERE id = " + phoneNumber.getId();
        List<PhoneNumber> phoneNumberWithID = jdbcTemplate.query(sqlCheckDuplicateID, phoneNumberRowMapper);

        String sqlCheckNrDuplicate = "SELECT * FROM phoneNumber WHERE number = " + phoneNumber.getNumber();
        List<PhoneNumber> phoneNumberWithNr = jdbcTemplate.query(sqlCheckNrDuplicate, phoneNumberRowMapper);

        try {
            if (!phoneNumberWithID.isEmpty()) {
                throw new DuplicateIdException(phoneNumber.getId(), PhoneNumber.class);
            }

            if (!phoneNumberWithNr.isEmpty()) {
                throw new DuplicatePhoneNrException(phoneNumber.getNumber());
            }

            int insert = jdbcTemplate.update(sql, phoneNumber.getId(), phoneNumber.getNumber(), phoneNumber.getServiceProvider(), phoneNumber.getOwnerId());

            if (insert == 1) {
                logger.info("Inserted phone number: " + phoneNumber);
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    public void delete(PhoneNumber phoneNumber){
        String sql = "DELETE FROM phoneNumber WHERE id = " + phoneNumber.getId();
        logger.info("Deleted phone number: " + phoneNumber);

        jdbcTemplate.execute(sql);
    }

    public String getNrOfPersonWithId(int personId){
        String sqlNr = "SELECT number FROM phoneNumber WHERE ownerId = " + personId;

        return jdbcTemplate.queryForObject(sqlNr, String.class);
    }

    public void update(int personId, PhoneNumber newPhoneNumber){
        String sql = "UPDATE phonenumber SET number = ?, serviceProvider = ? WHERE ownerId = ?";

        String sqlCheckNrDuplicate = "SELECT * FROM phoneNumber WHERE number = " + newPhoneNumber.getNumber();
        List<PhoneNumber> phoneNumberWithNr = jdbcTemplate.query(sqlCheckNrDuplicate, phoneNumberRowMapper);
        try{
            if(!phoneNumberWithNr.isEmpty()){
                throw new DuplicatePhoneNrException(newPhoneNumber.getNumber());
            }
            int update = jdbcTemplate.update(sql, newPhoneNumber.getNumber(), newPhoneNumber.getServiceProvider(), personId);

            if (update == 1) {
                logger.info("Person with id " + personId + " updated with new phone number: " + newPhoneNumber.getNumber());
            }
        }
        catch(SQLException e)
        {
            logger.info(e.getMessage());
        }
    }
}

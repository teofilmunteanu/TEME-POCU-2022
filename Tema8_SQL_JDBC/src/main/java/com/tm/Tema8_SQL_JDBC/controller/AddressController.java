package com.tm.Tema8_SQL_JDBC.controller;

import com.tm.Tema8_SQL_JDBC.exceptions.DuplicateIdException;
import com.tm.Tema8_SQL_JDBC.exceptions.DuplicateOwnerException;
import com.tm.Tema8_SQL_JDBC.exceptions.DuplicatePhoneNrException;
import com.tm.Tema8_SQL_JDBC.model.Address;
import com.tm.Tema8_SQL_JDBC.model.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class AddressController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private JdbcTemplate jdbcTemplate;

    public AddressController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Address> addressRowMapper = (rs, rowNum) -> {
        Address address = new Address();

        address.setId(rs.getInt("id"));
        address.setCountry(rs.getString("country"));
        address.setCity(rs.getString("city"));
        address.setStreet(rs.getString("street"));
        address.setOwnerId(rs.getInt("ownerId"));

        return address;
    };

    public void create(Address address){
        String sql = "INSERT INTO address(country, city, street, ownerId) VALUES(?,?,?,?)";

        int insert = jdbcTemplate.update(sql, address.getCountry(), address.getCity(), address.getStreet() , address.getOwnerId());

        if(insert == 1){
            logger.info("Inserted address: " + address);
        }
    }

    public void createWithID(Address address){
        String sql = "INSERT INTO address(id, country, city, street, ownerId) VALUES(?,?,?,?,?)";

        String sqlCheckDuplicateID = "SELECT * FROM address WHERE id = " + address.getId();
        List<Address> addressWithID = jdbcTemplate.query(sqlCheckDuplicateID, addressRowMapper);
        String sqlCheckDuplicateOwner = "SELECT * FROM address WHERE ownerId = " + address.getOwnerId();
        List<Address> addressWithOwner = jdbcTemplate.query(sqlCheckDuplicateOwner, addressRowMapper);

        try{
            if(!addressWithID.isEmpty()){
                throw new DuplicateIdException(address.getId(), Address.class);
            }

            if(!addressWithOwner.isEmpty()){
                throw new DuplicateOwnerException(address.getOwnerId(), Address.class);
            }

            int insert = jdbcTemplate.update(sql, address.getId(), address.getCountry(), address.getCity(), address.getStreet() , address.getOwnerId());

            if(insert == 1){
                logger.info("Inserted address: " + address);
            }
        }
        catch(SQLException e){
            logger.info(e.getMessage());
        }
    }

    public void delete(Address address){
        String sql = "DELETE FROM address WHERE id = " + address.getId();
        logger.info("Deleted address: " + address);

        jdbcTemplate.execute(sql);
    }

    public List<Address> getAddressOfPersonWithId(int personId){
        String sqlNr = "SELECT * FROM address WHERE ownerId = " + personId;

        return jdbcTemplate.query(sqlNr, addressRowMapper);
    }

    public void update(int personId, Address newAddress){
        String sql = "UPDATE address SET country = ?, city = ?, street = ? WHERE ownerId = ?";


        int update = jdbcTemplate.update(sql, newAddress.getCountry(), newAddress.getCity(), newAddress.getStreet() , personId);

        if (update == 1) {
            logger.info("Person with id " + personId + " updated with new address: " + newAddress.getCountry() + " " + newAddress.getCity() + " " + newAddress.getStreet());
        }
    }
}

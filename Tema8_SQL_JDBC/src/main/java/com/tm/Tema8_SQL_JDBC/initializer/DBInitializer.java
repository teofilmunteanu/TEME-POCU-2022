package com.tm.Tema8_SQL_JDBC.initializer;

import com.tm.Tema8_SQL_JDBC.controller.AddressController;
import com.tm.Tema8_SQL_JDBC.controller.PersonController;
import com.tm.Tema8_SQL_JDBC.controller.PhoneNumberController;
import com.tm.Tema8_SQL_JDBC.model.Address;
import com.tm.Tema8_SQL_JDBC.model.Person;
import com.tm.Tema8_SQL_JDBC.model.PhoneNumber;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;

public class DBInitializer {
    private JdbcTemplate jdbcTemplate;

    private static PersonController personController;
    private static AddressController addressController;
    private static PhoneNumberController phoneNumberController;

    public DBInitializer(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;

        personController = new PersonController(jdbcTemplate);
        addressController = new AddressController(jdbcTemplate);
        phoneNumberController = new PhoneNumberController(jdbcTemplate);
    }

    public void createPersonTable(){
        String sql = "CREATE TABLE IF NOT EXISTS person (" +
                " id INT NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(50) NOT NULL," +
                " birthDay DATE NOT NULL," +
                " birthPlace VARCHAR(50) NOT NULL, " +
                " PRIMARY KEY (id) " +
                ");";

        jdbcTemplate.execute(sql);
    }

    public void createAddressTable(){
        String sql = "CREATE TABLE IF NOT EXISTS address (" +
                " id INT NOT NULL AUTO_INCREMENT," +
                " country VARCHAR(50) NOT NULL," +
                " city VARCHAR(50) NOT NULL," +
                " street VARCHAR(50) NOT NULL, " +
                " ownerId INT UNIQUE NOT NULL, " +
                " PRIMARY KEY (id), " +
                " FOREIGN KEY (ownerId) REFERENCES person(id) ON DELETE CASCADE" +
                ");";

        jdbcTemplate.execute(sql);
    }

    public void createPhoneNumberTable(){
        String sql = "CREATE TABLE IF NOT EXISTS phoneNumber (" +
                " id INT NOT NULL AUTO_INCREMENT," +
                " number VARCHAR(50) UNIQUE NOT NULL," +
                " serviceProvider VARCHAR(50) NOT NULL," +
                " ownerId INT NOT NULL, " +
                " PRIMARY KEY (id), " +
                " FOREIGN KEY (ownerId) REFERENCES person(id)  ON DELETE CASCADE" +
                ");";

        jdbcTemplate.execute(sql);
    }

    public void insertPersonValues(){
        Person person1 = new Person(1, "test1", new Date(71,1,1), "Iasi");
        Person person2 = new Person(2, "test2", new Date(91,3,1), "Bucuresti");
        Person person3 = new Person(3, "test3", new Date(91,3,1), "Cluj");
        Person person4 = new Person(4, "test4", new Date(103,3,1), "London");
        Person person5 = new Person(5, "test5", new Date(101,3,1), "Iasi");
        Person person99 = new Person(99, "test99", new Date(101,10,1), "Brasov");

        personController.delete(person1);
        personController.createWithID(person1);
        personController.createWithID(person2);
        personController.createWithID(person3);
        personController.createWithID(person4);
        personController.createWithID(person5);
        personController.createWithID(person99);
    }

    public void insertAddressValues(){
        Address address1 = new Address(1,"Romania", "Iasi", "Vitejilor", 1);
        Address address1c = new Address(1,"Romania", "Vaslui", "1 Mai", 99);
        Address address2 = new Address(2, "Romania", "Iasi", "Buridava", 1);
        Address address3 = new Address(3, "Romania", "Vaslui", "Primaverii", 2);
        Address address4 = new Address(4, "Romania", "Iasi", "Buridava", 3);
        Address address5 = new Address(5, "Britain", "London", "Abbey", 4);
        Address address6 = new Address(6,"Romania", "Iasi", "Vitejilor", 5);

        addressController.createWithID(address1);
        addressController.createWithID(address1c);
        addressController.createWithID(address2);
        addressController.createWithID(address3);
        addressController.createWithID(address4);
        addressController.createWithID(address5);
        addressController.createWithID(address6);
    }

    public void insertPhoneNumberValues(){
        PhoneNumber phoneNumber1 = new PhoneNumber(1, "0774123456", "Orange", 1);
        PhoneNumber phoneNumber2 = new PhoneNumber(2, "0774654321", "Orange", 2);
        PhoneNumber phoneNumber3 = new PhoneNumber(3, "0774654321", "Digi", 3);
        PhoneNumber phoneNumber4 = new PhoneNumber(4, "0774357456", "Telecom", 2);

        phoneNumberController.createWithID(phoneNumber1);
        phoneNumberController.createWithID(phoneNumber2);
        phoneNumberController.createWithID(phoneNumber3);
        phoneNumberController.createWithID(phoneNumber4);
    }
}

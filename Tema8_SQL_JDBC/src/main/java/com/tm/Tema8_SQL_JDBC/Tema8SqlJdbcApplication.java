package com.tm.Tema8_SQL_JDBC;

import com.tm.Tema8_SQL_JDBC.controller.AddressController;
import com.tm.Tema8_SQL_JDBC.controller.PersonController;
import com.tm.Tema8_SQL_JDBC.controller.PhoneNumberController;
import com.tm.Tema8_SQL_JDBC.initializer.DBInitializer;
import com.tm.Tema8_SQL_JDBC.model.Address;
import com.tm.Tema8_SQL_JDBC.model.Person;
import com.tm.Tema8_SQL_JDBC.model.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;

@SpringBootApplication
public class Tema8SqlJdbcApplication implements CommandLineRunner{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static PersonController personController;
	private static AddressController addressController;
	private static PhoneNumberController phoneNumberController;


	public static void main(String[] args) {
		SpringApplication.run(Tema8SqlJdbcApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		DBInitializer dbInitializer = new DBInitializer(jdbcTemplate);
		dbInitializer.createPersonTable();
		dbInitializer.createAddressTable();
		dbInitializer.createPhoneNumberTable();

		personController = new PersonController(jdbcTemplate);
		addressController = new AddressController(jdbcTemplate);
		phoneNumberController = new PhoneNumberController(jdbcTemplate);

		dbInitializer.insertPersonValues();
		dbInitializer.insertAddressValues();
		dbInitializer.insertPhoneNumberValues();


		System.out.println("People born before 1990: " + personController.getPersonsBornBefore1990());

		System.out.println("People living in their natal city: " + personController.getPersonsLivingInNatalCity());

		System.out.println(personController.getPersonsLivingInSameCountry(1));
		System.out.println(personController.getPersonsLivingInSameCity(1));
		System.out.println(personController.getPersonsLivingInSameStreet(1));

		System.out.println(personController.getPersonsSamePhoneServiceProvider(1));

		PhoneNumber newPhoneNumber = new PhoneNumber("0774111222", "Digi");
		System.out.println("Initial phone number: " + phoneNumberController.getNrOfPersonWithId(1));
		phoneNumberController.update(1, newPhoneNumber);

		Address newAddress = new Address("Japan", "Kyoto", "Gojo");
		System.out.println("Initial address: " + addressController.getAddressOfPersonWithId(1));
		addressController.update(1, newAddress);

	}
}

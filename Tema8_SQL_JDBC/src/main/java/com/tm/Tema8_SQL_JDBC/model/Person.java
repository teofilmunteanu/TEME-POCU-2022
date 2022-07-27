package com.tm.Tema8_SQL_JDBC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private Date birthDay;
    private String birthPlace;//city

    public Person(String name, Date birthDay, String birthPlace) {
        this.name = name;
        this.birthDay = birthDay;
        this.birthPlace = birthPlace;
    }
}

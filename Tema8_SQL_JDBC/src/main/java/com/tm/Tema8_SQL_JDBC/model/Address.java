package com.tm.Tema8_SQL_JDBC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int id;
    private String country;
    private String city;
    private String street;
    private int ownerId;

    public Address(String country, String city, String street, int ownerId) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.ownerId = ownerId;
    }

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }
}

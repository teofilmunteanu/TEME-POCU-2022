package com.tm.Tema8_SQL_JDBC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    private int id;
    private String number;
    private String serviceProvider;
    private int ownerId;

    public PhoneNumber(String number, String serviceProvider, int ownerId) {
        this.number = number;
        this.serviceProvider = serviceProvider;
        this.ownerId = ownerId;
    }

    public PhoneNumber(String number, String serviceProvider) {
        this.number = number;
        this.serviceProvider = serviceProvider;
    }
}

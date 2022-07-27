package com.tm.Tema8_SQL_JDBC.exceptions;

import com.tm.Tema8_SQL_JDBC.model.Address;

import java.sql.SQLException;

public class DuplicateIdException extends SQLException {
    public <T>DuplicateIdException(int id, Class<T> cls) {
        super(cls.getSimpleName() + " with id " + id + " already exists!");
    }
}

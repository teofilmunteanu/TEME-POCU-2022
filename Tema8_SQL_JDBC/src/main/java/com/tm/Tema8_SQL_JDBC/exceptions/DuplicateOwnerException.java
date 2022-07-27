package com.tm.Tema8_SQL_JDBC.exceptions;

import java.sql.SQLException;

public class DuplicateOwnerException extends SQLException {
    public <T>DuplicateOwnerException(int id, Class<T> cls) {
        super("Person with id " + id + " already has a " + cls.getSimpleName() + " !");
    }
}

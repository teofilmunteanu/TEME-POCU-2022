package com.tm.Tema8_SQL_JDBC.exceptions;

import java.sql.SQLException;

public class DuplicatePhoneNrException extends SQLException{
    public DuplicatePhoneNrException(String number) {
        super("Phone number " + number + " already exists!");
    }
}


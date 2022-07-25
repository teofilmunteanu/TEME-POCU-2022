package com.project.Tema7_springWeb.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidIdException extends RuntimeException {
    public InvalidIdException() {
        super("Id is invalid, it must be positive!");
    }
}

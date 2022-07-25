package com.project.Tema7_springWeb.advice;

import com.project.Tema7_springWeb.exceptions.InvalidIdException;
import com.project.Tema7_springWeb.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {
    private Map setupBodyMessage(Exception exception){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", exception.getMessage());

        return body;
    }


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> noUserException(UserNotFoundException exception) {
        /* Changerd logging level in application.properties  from info(default) to debug */
        log.debug("Exception: " + exception.getMessage());
        return new ResponseEntity<>(setupBodyMessage(exception), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<Object> invalidIdException(InvalidIdException exception) {
        /* Changerd logging level in application.properties from info(default) to debug */
        log.debug("Exception: " + exception.getMessage());
        return new ResponseEntity<>(setupBodyMessage(exception), HttpStatus.BAD_REQUEST);
    }

}

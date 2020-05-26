package com.api.searchzipcode.utils;

import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHanlderAdvice extends ResponseEntityExceptionHandler {

    private final String WRONG_FORMAT = "Invalid query parameter constraint!";
    private final String DATA_NOT_FOUND = "No zip code found!";

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex){
        return new ResponseEntity<>(Utils.builderBodyResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                WRONG_FORMAT
        ), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex){
        return new ResponseEntity<>(Utils.builderBodyResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                DATA_NOT_FOUND
        ), HttpStatus.NOT_FOUND);
    }
}
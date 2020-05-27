package com.api.searchzipcode.utils;

import javax.validation.ConstraintViolationException;

import com.api.searchzipcode.utils.constants.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHanlderAdvice extends ResponseEntityExceptionHandler {

    /**
     * Handler method for ConstraintViolationException
     *
     * @param ex ConstraintViolationException object
     * @return ResponseEntity object with a timestamp, error, message and http status code
     * @author João Pedro Martins Souza
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex){
        return new ResponseEntity<>(Utils.builderBodyResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                ResponseMessage.WRONG_FORMAT
        ), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handler method for ResourceNotFoundException
     *
     * @param ex ResourceNotFoundException object
     * @return ResponseEntity object with a timestamp, error, message and http status code
     * @author João Pedro Martins Souza
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex){
        return new ResponseEntity<>(Utils.builderBodyResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                ResponseMessage.DATA_NOT_FOUND
        ), HttpStatus.NOT_FOUND);
    }

    /**
     * Default method to Handler an no mapped Exception
     *
     * @param ex Exception object
     * @return ResponseEntity object with a timestamp, error, message and http status code
     * @author João Pedro Martins Souza
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex){
        return new ResponseEntity<>(Utils.builderBodyResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                ResponseMessage.INTERNAL_ERROR
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

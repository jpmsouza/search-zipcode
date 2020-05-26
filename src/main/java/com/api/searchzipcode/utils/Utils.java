package com.api.searchzipcode.utils;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;

public final class Utils {

    private static final String REGEX = "(?=\\d0*$).";

    private Utils(){
        throw new UnsupportedOperationException();
    }

    /**
     * Replace the given string with zero from right to left has a defined regex
     *
     * @param value String value
     * @return String object
     * @author João Pedro Martins Souza
     */
    public static String replaceWithZeros(String value){
        return value.replaceAll(REGEX,"0");
    }

    /**
     *  Create a HashMap object to build body for ResponseEntity
     *
     * @param httpStatusCode int value for Http status code
     * @param error String value for error
     * @param message String value for message
     * @return HashMap Object
     * @author João Pedro Martins Souza
     */
    public static HashMap<String, Object> builderBodyResponse(int httpStatusCode, String error, String message){
        final HashMap<String, Object> body = new HashMap<>();
        body.put("timestamp",LocalDateTime.now());
        body.put("status", httpStatusCode);
        body.put("error", error);
        body.put("message", message);
        return body;
    }
}

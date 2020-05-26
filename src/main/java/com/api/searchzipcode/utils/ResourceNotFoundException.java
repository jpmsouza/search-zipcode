package com.api.searchzipcode.utils;

public class ResourceNotFoundException extends RuntimeException {

    private final static String NO_DATA_FOUND = "No data found!";

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public ResourceNotFoundException() {
        super(NO_DATA_FOUND);
    }
}

package com.api.searchzipcode.utils;

import com.api.searchzipcode.utils.constants.ResponseMessage;

public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public ResourceNotFoundException() {
        super(ResponseMessage.NO_DATA_FOUND);
    }
}

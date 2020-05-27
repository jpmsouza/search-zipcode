package com.api.searchzipcode.utils.constants;

public final class ResponseMessage {

    public static final String WRONG_FORMAT = "Invalid query parameter constraint!";
    public static final String DATA_NOT_FOUND = "No zip code found!";
    public static final String NO_DATA_FOUND = "No data found!";
    public static final String INTERNAL_ERROR = "Internal Error!";

    private ResponseMessage(){
        throw new UnsupportedOperationException();
    }
}

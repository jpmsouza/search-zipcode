package com.api.searchzipcode.utils.constants;

public final class TestConditionsValue {

    public static final String INVALID_CODE = "1234567a";
    public static final String VALID_CODE = "12345670";
    public static final String NO_EXIST_CODE = "12345600";
    public static final String WRONG_DIGIT_CODE = "12345678";
    public static final String CITY = "São José";
    public static final String STATE = "SP";
    public static final String STOP_AT_ZEROS =  "00000000";

    private TestConditionsValue(){
        throw new UnsupportedOperationException();
    }
}

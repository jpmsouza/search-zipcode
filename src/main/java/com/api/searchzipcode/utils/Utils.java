package com.api.searchzipcode.utils;

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
}

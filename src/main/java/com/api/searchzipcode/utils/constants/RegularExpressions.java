package com.api.searchzipcode.utils.constants;

public final class RegularExpressions {

    public static final String VALID_ZIP_CODE = "^\\d{8}$";
    public static final String DIGIT_FOLLOWED_BY_ZERO = "(?=\\d0*$).";

    private RegularExpressions(){
        throw new UnsupportedOperationException();
    }
}

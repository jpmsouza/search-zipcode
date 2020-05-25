package com.api.searchzipcode.services;

import com.api.searchzipcode.domains.ZipCode;


public interface ZipCodeService {

    /**
     *  Method scope to find a ZipCode entity by postalCode value
     *
     * @param postalCode String value of postal code
     * @return ZipCode Object
     * @author João Pedro Martins Souza
     */
    public ZipCode findZipCodeByPostalCode(String postalCode);
}

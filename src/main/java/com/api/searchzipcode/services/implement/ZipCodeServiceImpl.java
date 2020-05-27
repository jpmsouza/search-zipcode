package com.api.searchzipcode.services.implement;

import com.api.searchzipcode.domains.ZipCode;
import com.api.searchzipcode.repositories.ZipCodeRepository;
import com.api.searchzipcode.services.ZipCodeService;
import com.api.searchzipcode.utils.Utils;
import com.api.searchzipcode.utils.constants.TestConditionsValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {

    @Autowired
    private ZipCodeRepository  zipCodeRepository;

    /**
     *  Implementation for findZipCodeByPostalCode interface method
     *  Find a ZipCode entity by postalCode value
     *
     * @param postalCode String value of postal code
     * @return ZipCode Object
     * @author João Pedro Martins Souza
     */
    @Override
    public ZipCode findZipCodeByPostalCode(String postalCode) {
        ZipCode zipCode = zipCodeRepository.findByPostalCode(postalCode);
        if (zipCode != null || postalCode.equals(TestConditionsValue.STOP_AT_ZEROS)){
            return zipCode;
        }else {
            return this.findZipCodeByPostalCode(Utils.replaceWithZeros(postalCode));
        }
    }
}

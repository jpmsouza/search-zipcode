package com.api.searchzipcode.services.implement;

import com.api.searchzipcode.domains.ZipCode;
import com.api.searchzipcode.repositories.ZipCodeRepository;
import com.api.searchzipcode.services.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {

    @Autowired
    private ZipCodeRepository  zipCodeRepository;

    @Override
    public ZipCode findZipCodeByPostalCode(String postalCode) {
        ZipCode zipCode = zipCodeRepository.findByPostalCode(postalCode);
        if (zipCode != null || postalCode.equals("00000000")){
            return zipCode;
        }else {
            return this.findZipCodeByPostalCode(postalCode.replaceAll("(?=\\d0*$).","0"));
        }
    }
}

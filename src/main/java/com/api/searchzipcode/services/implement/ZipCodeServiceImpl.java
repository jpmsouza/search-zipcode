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
    public ZipCode findZipCodeByPostalCode(Integer postalCode) {
        return zipCodeRepository.findByPostalCode(postalCode);
    }
}

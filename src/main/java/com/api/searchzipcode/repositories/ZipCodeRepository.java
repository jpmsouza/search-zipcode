package com.api.searchzipcode.repositories;

import com.api.searchzipcode.domains.ZipCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZipCodeRepository extends JpaRepository<ZipCode, Integer> {

    /**
     * Find a ZipCode register by postal code value
     *
     * @param postalCode String value of ZipCode
     * @return ZipCode Object
     * @author João Pedro Martins Souza
     */
    ZipCode findByPostalCode(String postalCode);
}

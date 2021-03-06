package com.api.searchzipcode.controllers;

import com.api.searchzipcode.domains.ZipCode;
import com.api.searchzipcode.services.ZipCodeService;
import com.api.searchzipcode.utils.constants.RegularExpressions;
import com.api.searchzipcode.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/zip-code")
@Validated
public class ZipCodeController {

    @Autowired
    private ZipCodeService zipCodeService;

    /**
     * Get a zip code entity by postal code value
     *
     * @param postalCode String value of postal code
     * @return ResponseEntity Object with respective Http status code and body
     * @author João Pedro Martins Souza
     */
    @GetMapping("/{postalCode}")
    public ResponseEntity<ZipCode> getZipCodeByPostalCode(@PathVariable  @Pattern(regexp= RegularExpressions.VALID_ZIP_CODE) String postalCode){
        ZipCode zipCode = zipCodeService.findZipCodeByPostalCode(postalCode);
        if (zipCode==null){
            throw new ResourceNotFoundException();
        }else {
            return new ResponseEntity<>(zipCode, HttpStatus.OK);
        }

    }
}

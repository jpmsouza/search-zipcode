package com.api.searchzipcode.controllers;

import com.api.searchzipcode.domains.ZipCode;
import com.api.searchzipcode.services.ZipCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/zip-code")
@Validated
public class ZipCodeController {

    @Autowired
    private ZipCodeService zipCodeService;

    @GetMapping("/{postalCode}")
    public ResponseEntity<ZipCode> getZipCodeByPostalCode(@PathVariable  @Pattern(regexp="^\\d{8}$") String postalCode){
        return new ResponseEntity<>(zipCodeService.findZipCodeByPostalCode(Integer.parseInt(postalCode)), HttpStatus.OK);
    }
}

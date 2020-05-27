package com.api.searchzipcode.services.implement;

import com.api.searchzipcode.domains.ZipCode;
import com.api.searchzipcode.repositories.ZipCodeRepository;
import com.api.searchzipcode.services.ZipCodeService;
import com.api.searchzipcode.utils.constants.TestConditionsValue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ZipCodeServiceImplTest {

    @TestConfiguration
    static class ZipCodeServiceImplTestConfiguration{
        @Bean
        public ZipCodeService zipCodeService(){
            return new ZipCodeServiceImpl();
        }
    }

    @Autowired
    private ZipCodeService zipCodeService;

    @MockBean
    private ZipCodeRepository zipCodeRepository;

    @Before
    public void setup(){
        ZipCode zipCode = new ZipCode();
        zipCode.setPostalCode(TestConditionsValue.VALID_CODE);
        zipCode.setState(TestConditionsValue.STATE);
        zipCode.setCity(TestConditionsValue.CITY);
        zipCode.setIbgeCode(TestConditionsValue.VALID_CODE);

        Mockito.when(zipCodeRepository.findByPostalCode(zipCode.getPostalCode())).thenReturn(zipCode);
    }

    @Test
    public void whenValidPostalCode_thenZipCodeShouldBeFound(){
        Assert.assertEquals(TestConditionsValue.VALID_CODE,
                zipCodeService.findZipCodeByPostalCode(TestConditionsValue.VALID_CODE).getPostalCode());
    }

    @Test
    public void whenNotValidPostalCode_thenZipCodeShouldNotBeFound(){
        Assert.assertNull(zipCodeService.findZipCodeByPostalCode(TestConditionsValue.NO_EXIST_CODE));
    }

    @Test
    public void whenValidPostalCodeWithWrongDigit_thenZipCodeShouldBeFound(){
        Assert.assertEquals(TestConditionsValue.VALID_CODE,
                zipCodeService.findZipCodeByPostalCode(TestConditionsValue.WRONG_DIGIT_CODE).getPostalCode());
    }
}

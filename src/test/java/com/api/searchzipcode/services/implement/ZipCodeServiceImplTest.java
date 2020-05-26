package com.api.searchzipcode.services.implement;

import com.api.searchzipcode.domains.ZipCode;
import com.api.searchzipcode.repositories.ZipCodeRepository;
import com.api.searchzipcode.services.ZipCodeService;
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

    private final String CODE = "12345670";
    private final String INVALID_CODE = "12345668";
    private final String WRONG_DIGIT_CODE = "12345678";

    @Before
    public void setup(){
        ZipCode zipCode = new ZipCode();
        zipCode.setPostalCode(CODE);
        zipCode.setState("MG");
        zipCode.setCity("São José");
        zipCode.setIbgeCode(CODE);

        Mockito.when(zipCodeRepository.findByPostalCode(zipCode.getPostalCode())).thenReturn(zipCode);
    }

    @Test
    public void whenValidPostalCode_thenZipCodeShouldBeFound(){
        Assert.assertEquals(CODE,
                zipCodeService.findZipCodeByPostalCode(CODE).getPostalCode());
    }

    @Test
    public void whenNotValidPostalCode_thenZipCodeShouldNotBeFound(){
        Assert.assertNull(zipCodeService.findZipCodeByPostalCode(INVALID_CODE));
    }

    @Test
    public void whenValidPostalCodeWithWrongDigit_thenZipCodeShouldBeFound(){
        Assert.assertEquals(CODE,
                zipCodeService.findZipCodeByPostalCode(WRONG_DIGIT_CODE).getPostalCode());
    }
}

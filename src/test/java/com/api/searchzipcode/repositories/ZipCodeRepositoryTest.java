package com.api.searchzipcode.repositories;

import com.api.searchzipcode.domains.ZipCode;
import com.api.searchzipcode.spring.SearchZipcodeApplication;
import com.api.searchzipcode.utils.constants.TestConditionsValue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes={SearchZipcodeApplication.class})
public class ZipCodeRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ZipCodeRepository zipCodeRepository;

    @Test
    public void whenFindByPostalCode_thenReturnZipCode(){
        String postalCode = TestConditionsValue.VALID_CODE;
        ZipCode zipCode = new ZipCode();
        zipCode.setPostalCode(TestConditionsValue.VALID_CODE);
        zipCode.setCity(TestConditionsValue.CITY);
        zipCode.setState(TestConditionsValue.STATE);
        zipCode.setIbgeCode(TestConditionsValue.VALID_CODE);
        testEntityManager.persist(zipCode);
        testEntityManager.flush();

        Assert.assertEquals(zipCodeRepository.findByPostalCode(postalCode),zipCode);
    }
}

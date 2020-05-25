package com.api.searchzipcode.repositories;

import com.api.searchzipcode.domains.ZipCode;
import com.api.searchzipcode.spring.SearchZipcodeApplication;
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
        Integer postalCode = new Integer(12345678);
        ZipCode zipCode = new ZipCode();
        zipCode.setPostalCode(new Integer(12345678));
        zipCode.setCity("São José");
        zipCode.setState("SP");
        zipCode.setIbgeCode(new Integer(12345678));
        testEntityManager.persist(zipCode);
        testEntityManager.flush();

        Assert.assertEquals(zipCodeRepository.findByPostalCode(postalCode),zipCode);
    }
}

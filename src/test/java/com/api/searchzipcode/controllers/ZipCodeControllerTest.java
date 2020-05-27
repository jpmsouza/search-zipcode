package com.api.searchzipcode.controllers;

import com.api.searchzipcode.domains.ZipCode;
import com.api.searchzipcode.services.ZipCodeService;
import com.api.searchzipcode.services.implement.ZipCodeServiceImpl;
import com.api.searchzipcode.utils.ExceptionHanlderAdvice;
import com.api.searchzipcode.utils.constants.ResponseMessage;
import com.api.searchzipcode.utils.constants.TestConditionsValue;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ZipCodeController.class)
@ContextConfiguration(classes={ZipCodeServiceImpl.class,ZipCodeController.class,ExceptionHanlderAdvice.class})
public class ZipCodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @MockBean
    private ZipCodeService zipCodeService;

    @Test
    public void givenPostalCode_whenGetZipCode_thenReturnJson() throws Exception{
        ZipCode zipCode = new ZipCode();
        zipCode.setPostalCode(TestConditionsValue.VALID_CODE);
        zipCode.setCity(TestConditionsValue.CITY);
        zipCode.setState(TestConditionsValue.STATE);
        zipCode.setIbgeCode(TestConditionsValue.VALID_CODE);

        Mockito.when(zipCodeService.findZipCodeByPostalCode(Mockito.anyString())).thenReturn(zipCode);

        mockMvc.perform(get("/zip-code/{postalCode}",TestConditionsValue.VALID_CODE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("postalCode",is(TestConditionsValue.VALID_CODE)));
    }

    @Test
    public void givenNoExistPostalCode_whenGetZipCode_thenReturnNotFound() throws Exception{
        Mockito.when(zipCodeService.findZipCodeByPostalCode(Mockito.anyString())).thenReturn(null);

        mockMvc.perform(get("/zip-code/{postalCode}",TestConditionsValue.NO_EXIST_CODE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("message",is(ResponseMessage.DATA_NOT_FOUND)));
    }

    @Test
    public void givenInvalidPostalCode_whenGetZipCode_thenReturnBadRequest() throws Exception{
        mockMvc.perform(get("/zip-code/{postalCode}",TestConditionsValue.INVALID_CODE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("message",is(ResponseMessage.WRONG_FORMAT)));
    }

    @Test
    public void givenUnhandledPostalCode_whenGetZipCode_thenReturnBadRequest() throws Exception{
        Mockito.when(zipCodeService.findZipCodeByPostalCode(Mockito.anyString())).thenThrow(new NullPointerException());
        mockMvc.perform(get("/zip-code/{postalCode}",TestConditionsValue.VALID_CODE)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("message",is(ResponseMessage.INTERNAL_ERROR)));
    }
}

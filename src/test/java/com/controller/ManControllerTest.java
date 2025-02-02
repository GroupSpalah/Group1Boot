package com.controller;

import com.domain.Email;
import com.domain.Man;
import com.domain.Phone;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.CrudService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ManController.class)
public class ManControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Mock
    CrudService<Man> service;


    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Test
    public void shouldSaveMan() throws Exception {

        Phone phone = Phone
                .builder()
                .number("067")
                .build();

        Email email1 = Email
                .builder()
                .name("mail.ua")
                .build();

        Email email2 = Email
                .builder()
                .name("ukr.net")
                .build();

        Man john = Man
                .builder()
                .age(32)
                .name("John")
                .phone(phone)
                .emails(List.of(email1, email2))
                .build();

        email1.setMan(john);
        email2.setMan(john);

        String json = OBJECT_MAPPER.writeValueAsString(john);

        Mockito.doNothing().when(service).save(john);

        mockMvc.perform(MockMvcRequestBuilders.post("/man/save")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

    }
}

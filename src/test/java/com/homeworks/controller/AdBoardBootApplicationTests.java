package com.homeworks.controller;

import com.homeworks.domain.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.homeworks.service.AdService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdController.class)
@AutoConfigureMockMvc
class AdBoardBootApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AdService service;

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void shouldSaveAuthor() throws Exception {

        Ad ad = createAd();

        String json = OBJECT_MAPPER.writeValueAsString(ad);

        Mockito.doNothing().when(service).create(ad);

        mockMvc.perform(MockMvcRequestBuilders.post("/ads-management/ads")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    public void shouldGetAd() throws Exception {

        Ad ad = createAd();

        Mockito.when(service.getById(ArgumentMatchers.anyInt())).thenReturn(ad);

        mockMvc
                .perform(get("/ads-management/ads/{id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Sale Xiaomi 15"))
                .andExpect(jsonPath("$.heading.name").value("Phones"))
                .andExpect(jsonPath("$.author.phones[0].phoneNumber").value("0987654321"));
    }

    private Ad createAd() {
        Email johnEmail = Email
                .builder()
                .email("john_travolta@gmail.com")
                .build();

        Address address = Address
                .builder()
                .district("Columbia")
                .city("Washington")
                .street("20 avenue")
                .build();

        Phone phone = Phone
                .builder()
                .phoneNumber("0987654321")
                .build();

        Author john = Author
                .builder()
                .firstName("John")
                .lastName("Travolta")
                .address(address)
                .email(johnEmail)
                .phones(Set.of(phone))
                .build();

        address.setAuthor(john);

        phone.setAuthor(john);

        Heading heading = Heading
                .builder()
                .name("Phones")
                .build();

        return Ad
                .builder()
                .heading(heading)
                .name("Sale Xiaomi 15")
                .publicationDate(LocalDate.now())
                .price(BigDecimal.valueOf(2000))
                .content("Selling Xiaomi 15")
                .author(john)
                //.isActive(false)
                .isActive(true)
                .build();
    }

}







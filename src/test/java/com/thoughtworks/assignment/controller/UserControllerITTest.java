package com.thoughtworks.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.assignment.TradeawayApplication;
import com.thoughtworks.assignment.controller.dto.UserRegistration;
import com.thoughtworks.assignment.domain.Seller;
import com.thoughtworks.assignment.domain.UserType;
import com.thoughtworks.assignment.repository.SellerBaseRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by vrushali on 6/19/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TradeawayApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:application-integration.properties")
public class UserControllerITTest {

    @Autowired
    private MockMvc mvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Resource
    private SellerBaseRepository sellerRepository;

    @Test
    public void shouldReturnSeller()
            throws Exception {
        UserRegistration user = new UserRegistration("test", "test_mail_1@test.com", "username_seller",  "address", "password", 9999, UserType.SELLER);
        user.setPanNumber("1234");
        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        final Seller seller = sellerRepository.findByEmail("test_mail_1@test.com");
        assertNotNull( seller);
    }

    @Test
    public void shouldReturnBuyer()
            throws Exception {
        UserRegistration user = new UserRegistration("test", "test_mail_2@test.com", "username_buyer",  "address", "password", 9999, UserType.BUYER);

        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test(expected = NestedServletException.class)
    public void shouldThrowExceptionWhenUsernameAlreadyExist()
            throws Exception {
        UserRegistration user = new UserRegistration("duplicate", "test_duplicate@test.com", "duplicate_username",  "address", "password", 9999, UserType.BUYER);

        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        expectedException.expect(NestedServletException.class);
    }

    @Test(expected = NestedServletException.class)
    public void shouldThrowExceptionWhenEmailAlreadyExist()
            throws Exception {
        UserRegistration user = new UserRegistration("duplicate_email", "duplicate_email@test.com", "duplicate_email",  "address", "password", 9999, UserType.BUYER);

        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());


        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}
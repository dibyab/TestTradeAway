package com.thoughtworks.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.assignment.TradeawayApplication;
import com.thoughtworks.assignment.domain.UserType;
import com.thoughtworks.assignment.controller.dto.UserRegistration;
import com.thoughtworks.assignment.validator.RegistrationFailedException;
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

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    @Test
    public void shouldReturnUser()
            throws Exception {
        UserRegistration user = new UserRegistration("test", "test_mail@test.com", "username",  "address", "password", 9999, UserType.BUYER);

        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo("test")));
    }

    @Test(expected = NestedServletException.class)
    public void shouldThrowExceptionWhenUsernameAlreadyExist()
            throws Exception {
        UserRegistration user = new UserRegistration("duplicate", "test_duplicate@test.com", "duplicate_username",  "address", "password", 9999, UserType.BUYER);

        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", equalTo("duplicate_username")));

        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", equalTo("duplicate_username")));

        expectedException.expect(NestedServletException.class);
    }

    @Test(expected = NestedServletException.class)
    public void shouldThrowExceptionWhenEmailAlreadyExist()
            throws Exception {
        UserRegistration user = new UserRegistration("duplicate_email", "duplicate_email@test.com", "duplicate_email",  "address", "password", 9999, UserType.BUYER);

        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", equalTo("duplicate_email@test.com")));

        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", equalTo("duplicate_email@test.com")));
    }

}
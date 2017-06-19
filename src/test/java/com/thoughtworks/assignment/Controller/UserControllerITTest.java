package com.thoughtworks.assignment.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.assignment.TradeawayApplication;
import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.domain.UserType;
import com.thoughtworks.assignment.dto.UserRegistration;
import com.thoughtworks.assignment.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

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

    @Test
    public void shouldReturnUser()
            throws Exception {


        UserRegistration user = new UserRegistration("test", "test_mail@test.com", "username",  "address", "password", 9999, UserType.BUYER);

        mvc.perform(post("/user")
                .content(mapper.writeValueAsString(user).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("test")));
    }

}
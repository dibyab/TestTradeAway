package com.thoughtworks.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.assignment.TradeawayApplication;
import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.repository.CategoryRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by vrushali on 6/20/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TradeawayApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:application-integration.properties")
public class CategoryControllerITTest {
    @Autowired
    private MockMvc mvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Resource
    private CategoryRepository categoryRepository;

    @Test
    public void shouldReturnItemsAssociatedWithACategory() throws Exception {
        mvc.perform(get("/categories/1/items")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.notNullValue()));
    }

    @Before
    public void setup() throws Exception{

        categoryRepository.deleteAll();
        createCategory("test_category1");
        createCategory("test_category2");
        createCategory("test_category3");
        createCategory("test_category4");
        createCategory("test_category5");
    }

    @Test
    public void shouldPerformPaginatedRequestWhenPageSizeIsNotGiven()
            throws Exception {

        mvc.perform(get("/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", is(5)))
                .andExpect(jsonPath("$.totalPages", is(1)));
    }

    @Test
    public void shouldPerformPaginatedRequesWhenPageSizeIsGiven()
            throws Exception {

        mvc.perform(get("/categories?pageNum=0&pageSize=3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPages", is(2)))
                .andExpect(jsonPath("$.totalElements", is(5)));

    }

    private void createCategory(String name) throws Exception {
        final Category testCategory1 = new Category(name);

        mvc.perform(post("/categories")
                .content(mapper.writeValueAsString( testCategory1).getBytes())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
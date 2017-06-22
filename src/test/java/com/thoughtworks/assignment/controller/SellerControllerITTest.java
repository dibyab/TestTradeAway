package com.thoughtworks.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.assignment.TradeawayApplication;
import com.thoughtworks.assignment.controller.dto.CreateStockDTO;
import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.domain.Seller;
import com.thoughtworks.assignment.domain.Stock;
import com.thoughtworks.assignment.repository.ItemRepository;
import com.thoughtworks.assignment.repository.SellerRepository;
import com.thoughtworks.assignment.repository.StockRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by vrushali on 6/22/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TradeawayApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:application-integration.properties")
public class SellerControllerITTest {

    @Resource
    private MockMvc mockMvc;

    @Resource
    private ItemRepository itemRepository;

    @Resource
    private SellerRepository sellerRepository;

    @Resource
    private StockRepository stockRepository;

    private int sellerId;

    private int itemId2;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setup() {

        itemRepository.deleteAll();
        stockRepository.deleteAll();
        sellerRepository.deleteAll();

        Item item1 = getItem("item1");
        Item item2 = getItem("item2");
        Item item3 = getItem("item3");

        Seller seller1 = new Seller("test", "test_mail_1@test.com", "username1", "address", "password", 9999);
        Seller seller2 = new Seller("test", "test_mail_2@test.com", "username2", "address", "password", 9999);

        seller1 = sellerRepository.save( seller1);
        seller2 = sellerRepository.save( seller2);
        sellerId = seller1.getId();

        item1 = itemRepository.save( item1);
        item2 = itemRepository.save( item2);
        itemId2 = item2.getId();
        item3 = itemRepository.save( item3);

        stockRepository.save( createStock(item1,seller1,30,1));
        stockRepository.save( createStock(item2,seller2,40,2));
        stockRepository.save( createStock(item3,seller2,50,3));
    }

    private Stock createStock( Item item,Seller seller, double price, int quantity) {
        Stock stock = new Stock( item,seller);
        stock.setPrice(price);
        stock.setQuantity( quantity);
        return stock;
    }
    private Item getItem(String name) {
        Item item = new Item(name,"desc1");
        return item;
    }

    @Test
    public void shouldReturnItemsNotAssociatedWithSeller() throws Exception {

        mockMvc.perform(get("/seller/"+ sellerId+"/getNewItems")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void shouldCreateNewStockForAnItem() throws Exception{

        CreateStockDTO createStockDTO = new CreateStockDTO();
        createStockDTO.setItemId(itemId2);
        createStockDTO.setPrice(50);
        createStockDTO.setQuantity(3);

        mockMvc.perform(post("/seller/" + sellerId+ "/items")
                .content( objectMapper.writeValueAsString( createStockDTO).getBytes())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isCreated());

        final Item item = itemRepository.findOne(itemId2);
        final Set<Stock> stockSet = item.getStockSet();
        assertEquals( 2,stockSet.size());
    }

}
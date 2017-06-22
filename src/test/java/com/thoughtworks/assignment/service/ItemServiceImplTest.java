package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.domain.Seller;
import com.thoughtworks.assignment.domain.Stock;
import com.thoughtworks.assignment.repository.ItemRepository;
import com.thoughtworks.assignment.repository.ItemSearchCriteria;
import com.thoughtworks.assignment.repository.StockRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by vrushali on 6/22/17.
 */
public class ItemServiceImplTest {

    @InjectMocks
    private ItemServiceImpl itemService = new ItemServiceImpl();

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private StockRepository stockRepository;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldFindItemsNotAssociatedWithSeller() throws Exception {

        when(stockRepository.findBySeller_IdNot( 123)).thenReturn(getStocks());
        final List<Item> items = itemService.findBySeller(new ItemSearchCriteria(123, false));
        assertEquals(2,items.size());
    }

    private List<Stock> getStocks() {

        List<Stock> stocks = new ArrayList<>(2);
        Stock stock = new Stock( getItem(), new Seller("test", "test_mail@test.com", "username",  "address", "password", 9999));
        Stock stock1 = new Stock( getItem(), new Seller("test", "test_mail@test.com", "username",  "address", "password", 9999));
        return Arrays.asList( stock,stock1);
    }

    private Item getItem() {
       return new Item("item1","desc1");
    }

}
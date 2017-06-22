package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by vrushali on 6/20/17.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class StockRepositoryTest {

    @Resource
    private TestEntityManager testEntityManager;

    @Resource
    private StockRepository stockRepository;

    @Resource
    private ItemRepository itemRepository;

    @Resource
    private UserRepository userRepository;

    @Before
    public void setup() {
        userRepository.deleteAll();
        itemRepository.deleteAll();
        stockRepository.deleteAll();
    }

    @Test
    public void shouldSaveStock(){
        Seller user = new Seller("test_user", "test_mail@test.com", "username",  "address", "password", 9999);
        Item item = new Item("item_test","test_desc");

        Stock stock = new Stock(item,user);
        stock.setPrice(10);
        stock.setQuantity(1);

        Stock result = stockRepository.save(stock);

        assertNotNull( result);
        assertEquals( 10,result.getPrice(),0);
        assertEquals( 1,result.getQuantity(),0);

        final Stock searchByManager = testEntityManager.find(Stock.class, result.getId());
        assertNotNull(searchByManager);
        assertEquals("item_test", searchByManager.getItem().getName());
        assertEquals("test_user", searchByManager.getSeller().getName());
    }

    @Test
    public void findItemsNotAssociatedWithSeller(){
        final Seller seller1 = testEntityManager.persistAndFlush(new Seller("test_user", "test_mail_1@test.com", "username1", "address", "password", 9999));
        final Item item1 = testEntityManager.persistAndFlush(new Item("item_seller1", "test_desc"));
        saveStock( item1,seller1);


        final Seller seller2 = testEntityManager.persistAndFlush(new Seller("test_user", "test_mail_2@test.com", "username2",  "address", "password", 9999));
        final Item item2 = testEntityManager.persistAndFlush(new Item("item_seller2","test_desc"));
        final Item item3 = testEntityManager.persistAndFlush(new Item("item_seller3", "test_desc"));
        saveStock( item2,seller2);
        saveStock( item3,seller2);

        final List<Stock> all = (List<Stock>)stockRepository.findAll();
        assertEquals(3,all.size());

        final List<Stock> bySellerNotIn = stockRepository.findBySeller_IdNot( seller1.getId());
        assertNotNull( bySellerNotIn);
        assertEquals( 2, bySellerNotIn.size());
    }



    private void saveStock( Item item, Seller seller){
        Stock stock = new Stock( item, seller);
        stock.setPrice(10);
        stock.setQuantity(1);
        testEntityManager.persistAndFlush(stock);
    }
}
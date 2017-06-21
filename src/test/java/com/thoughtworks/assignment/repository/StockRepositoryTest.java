package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.domain.Stock;
import com.thoughtworks.assignment.domain.User;
import com.thoughtworks.assignment.domain.UserType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

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
    public void shouldSaveStockWithUserAndItem(){
        User user = new User("test_user", "test_mail@test.com", "username",  "address", "password", 9999, UserType.BUYER);
        Item item = new Item("item_test","test_desc");

        Stock stock = new Stock(item,user);
        stock.setPrice(10);
        stock.setQuantity(1);

        Stock result = stockRepository.save(stock);

        assertNotNull( result);
        assertEquals( 10,result.getPrice(),0);
        assertEquals( 1,result.getQuantity(),0);

        final List<Item> items = (List<Item>)itemRepository.findAll();
        assertEquals(1, items.size());
        assertEquals("item_test", items.get(0).getName());

        final List<User> users = (List<User>)userRepository.findAll();
        assertEquals(1, users.size());
        assertEquals("test_user", users.get(0).getName());
    }

    @Test
    public void findItemsNotAssociatedWithSeller(){

    }

}
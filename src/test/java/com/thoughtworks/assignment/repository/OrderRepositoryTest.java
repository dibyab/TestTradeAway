package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * Created by dibyab on 6/21/17.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class OrderRepositoryTest {

    @Resource
    private TestEntityManager testEntityManager;

    @Resource
    private OrderRepository orderRepository ;

    @Test
    public void shouldBeAbleToPlaceOrder() {
        User buyer = new User("test", "test_mail@test.com", "username",  "address", "password", 9999, UserType.BUYER);
        User seller = new User("seller", "seller_mail@test.com", "seller",  "address", "password", 9999, UserType.SELLER);

        Category category = new Category("test_category");
        Item item = new Item("test_item1", "description1");
        category.addItem(item);

        testEntityManager.persistAndFlush(category);


        testEntityManager.persistAndFlush(buyer) ;
        testEntityManager.persistAndFlush(seller) ;
        Order order = new Order(item,buyer,seller,1,100,"xyz") ;
        final  Order persist = testEntityManager.persistAndFlush(order); ;

        assertEquals (orderRepository.findBySeller(seller).size(),2);

    }

}

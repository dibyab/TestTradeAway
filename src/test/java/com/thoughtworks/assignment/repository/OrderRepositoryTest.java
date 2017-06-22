package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        Buyer buyer = new Buyer("test", "test_mail@test.com", "username",  "address", "password", 9999);
        Seller seller = new Seller("seller", "seller_mail@test.com", "seller",  "address", "password", 9999);

        Category category = new Category("test_category");
        Item item = new Item("test_item1", "description1");
        category.addItem(item);

        testEntityManager.persistAndFlush(category);
        testEntityManager.persistAndFlush(buyer) ;
        final Seller persistSeller = testEntityManager.persistAndFlush(seller);

        Order order = new Order(item,seller,buyer,1,100,"xyz") ;
        final Order persist = testEntityManager.persistAndFlush(order);

        assertEquals( 1,orderRepository.findBySeller_Id(persistSeller.getId()).size());


    }

}

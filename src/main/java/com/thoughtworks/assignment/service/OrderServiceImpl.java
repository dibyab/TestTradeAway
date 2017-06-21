package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Order;
import com.thoughtworks.assignment.repository.OrderRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dibyab on 6/21/17.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderRepository orderRepository ;

    @Override
    public Order placeOrder(Order order) {
       return orderRepository.save(order) ;

    }
}

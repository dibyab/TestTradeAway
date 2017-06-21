package com.thoughtworks.assignment.controller;

import com.thoughtworks.assignment.controller.dto.OrderDTO;
import com.thoughtworks.assignment.domain.Category;
import com.thoughtworks.assignment.domain.Order;
import com.thoughtworks.assignment.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.function.Function;

/**
 * Created by dibyab on 6/21/17.
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService ;

    public static final  Function<Order,OrderDTO> orderOrderDTOFunction = order -> {

        OrderDTO orderDTO = new OrderDTO() ;
        orderDTO.setId(order.getId());
        orderDTO.setBuyer_name(order.getBuyer().getName());
        orderDTO.setSeller_name(order.getSeller().getName());
        orderDTO.setItem_name(order.getItem().getName());
        orderDTO.setPrice(order.getPrice());
        orderDTO.setDeliveryAddress(order.getDeliveryAddress());
        orderDTO.setQuantityPurchased(order.getQuantityPurchased());
        return orderDTO ;
    } ;



    @RequestMapping(
            value = "/orders",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO create( @RequestBody final Order order){
        return orderOrderDTOFunction.apply(orderService.placeOrder(order)) ;
    }
}

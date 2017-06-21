package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dibyab on 6/21/17.
 */
@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {

    List<Order> findById(Integer integer);
}

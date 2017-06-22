package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Order;
import com.thoughtworks.assignment.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dibyab on 6/21/17.
 */
@Transactional(readOnly = true)
@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    @Query
    List<Order>  findBySeller(Seller seller);

    List<Order>  findBySeller_Id(int id);
}

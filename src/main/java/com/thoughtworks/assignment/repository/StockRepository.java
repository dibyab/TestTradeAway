package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vrushali on 6/20/17.
 */
@Repository
public interface StockRepository extends CrudRepository<Stock,Integer> {

    List<Stock> findByUserIsNotIn(String user);
    
}

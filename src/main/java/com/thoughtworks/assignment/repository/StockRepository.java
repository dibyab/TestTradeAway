package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Stock;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vrushali on 6/20/17.
 */
@Repository
public interface StockRepository extends PagingAndSortingRepository<Stock,Integer> {

    List<Stock> findBySeller_IdNot(int sellerId);

    List<Stock> findBySellerId(int sellerId);
}

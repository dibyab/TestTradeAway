package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Seller;
import com.thoughtworks.assignment.domain.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vrushali on 6/20/17.
 */
@Repository
public interface StockRepository extends PagingAndSortingRepository<Stock,Integer> {

  //  @Query("select s from Stock s  INNER JOIN FETCH s.seller sl where sl.id =?1")
    @Query("SELECT s FROM Stock AS s LEFT JOIN s.seller AS sl WHERE sl.id = ?1")
    List<Stock> findAllWithSellerQuery(int sellerId);

    List<Stock> findBySeller_Id(int id);
}

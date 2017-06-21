package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vrushali on 6/20/17.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item,Integer> {

    List<Item> findByCategory_Id( Integer categoryId);

    Page<Item> findByCategory_CategoryName(String categoryName, Pageable pageable);


    //void findBy(ItemSearchCriteria searchCriteria);
}

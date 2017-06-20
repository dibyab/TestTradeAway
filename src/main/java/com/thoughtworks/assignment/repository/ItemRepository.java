package com.thoughtworks.assignment.repository;

import com.thoughtworks.assignment.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vrushali on 6/20/17.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item,Integer> {

}

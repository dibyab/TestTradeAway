package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.repository.ItemSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vrushali on 6/21/17.
 */
public interface ItemService {

    Page<Item> getItemsByCategory(String categoryName, Pageable pageable);

    List<Item> find( ItemSearchCriteria searchCriteria);
}

package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by vrushali on 6/21/17.
 */
public interface ItemService {

    Page<Item> getItemsByCategory(String categoryName, Pageable pageable);
}

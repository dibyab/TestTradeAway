package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by vrushali on 6/21/17.
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Resource
    private ItemRepository itemRepository;

    public Page<Item> getItemsByCategory(String categoryName, Pageable pageable) {
        return itemRepository.findByCategory_CategoryName(categoryName,pageable);
    }

}

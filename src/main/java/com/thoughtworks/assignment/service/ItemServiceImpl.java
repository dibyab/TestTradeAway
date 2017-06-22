package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.domain.Stock;
import com.thoughtworks.assignment.repository.ItemRepository;
import com.thoughtworks.assignment.repository.ItemSearchCriteria;
import com.thoughtworks.assignment.repository.StockRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vrushali on 6/21/17.
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Resource
    private ItemRepository itemRepository;

    @Resource
    private StockRepository stockRepository;

    public Page<Item> getItemsByCategory(String categoryName, Pageable pageable) {
        return itemRepository.findByCategory_CategoryName(categoryName,pageable);
    }

    @Override
    public List<Item> findBySeller(ItemSearchCriteria searchCriteria) {

        Assert.notNull( searchCriteria,"criteria should not be null");

        List<Item> items = new ArrayList<>();
        if( !searchCriteria.isIncludeSellerItem()) {
            final List<Stock> bySeller_idNot = stockRepository.findBySeller_IdNot(searchCriteria.getSellerId());
            items.addAll(bySeller_idNot.stream().map(Stock::getItem).collect(Collectors.toList()));
        }

        return items;
    }

    @Override
    public Item find(int itemId) {
        return itemRepository.findOne( itemId);
    }
}

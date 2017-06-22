package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.domain.Seller;
import com.thoughtworks.assignment.repository.ItemSearchCriteria;
import com.thoughtworks.assignment.repository.SellerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by vrushali on 6/21/17.
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Resource
    private ItemService itemService;

    @Resource
    private SellerRepository sellerRepository;

    @Override
    public List<Item> getNewItemsForSeller(int sellerId) {

        ItemSearchCriteria itemSearchCriteria = new ItemSearchCriteria(sellerId,false);
        return itemService.findBySeller( itemSearchCriteria);
    }

    @Override
    public Seller find(int sellerId) {
        return sellerRepository.findOne( sellerId);
    }
}

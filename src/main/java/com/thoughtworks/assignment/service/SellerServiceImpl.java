package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Item;
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

    @Override
    public List<Item> getNewItemsForSeller(String sellerId) {

        ItemSearchCriteria itemSearchCriteria = new ItemSearchCriteria(sellerId,false);
        itemService.find( itemSearchCriteria);
        return null;
    }
}

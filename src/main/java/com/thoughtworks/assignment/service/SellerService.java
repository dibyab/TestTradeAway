package com.thoughtworks.assignment.service;

import com.thoughtworks.assignment.domain.Item;
import com.thoughtworks.assignment.domain.Seller;

import java.util.List;

/**
 * Created by vrushali on 6/21/17.
 */
public interface SellerService {

    List<Item> getNewItemsForSeller(int sellerId);

    Seller find(int sellerId);
}

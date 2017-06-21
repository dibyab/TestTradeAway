package com.thoughtworks.assignment.repository;

/**
 * Created by vrushali on 6/21/17.
 */
public class ItemSearchCriteria {

    private String sellerId;
    private boolean includeSellerItem;

    public ItemSearchCriteria(String sellerId, boolean includeSellerItem) {
        this.sellerId = sellerId;
        this.includeSellerItem = includeSellerItem;
    }
}

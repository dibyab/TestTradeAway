package com.thoughtworks.assignment.repository;

/**
 * Created by vrushali on 6/21/17.
 */
public class ItemSearchCriteria {

    private int sellerId;
    private boolean includeSellerItem;

    public ItemSearchCriteria(int sellerId, boolean includeSellerItem) {
        this.sellerId = sellerId;
        this.includeSellerItem = includeSellerItem;
    }

    public boolean isIncludeSellerItem() {
        return includeSellerItem;
    }

    public int getSellerId() {
        return sellerId;
    }
}

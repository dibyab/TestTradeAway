package com.thoughtworks.assignment.domain;

import javax.persistence.*;

/**
 * Created by dibyab on 6/21/17.
 */
@Entity
@Table(name = "item")
public class Order {
    @Id
    @GeneratedValue()

    @Column(name = "order_id")
    private int id;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private User seller;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @Column(name = "quantity_purchased")
    private int quantityPurchased;

    @Column(name = "price")
    private double price;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    private Order() {
    }

    public Order(Item item, User seller, User buyer, int quantityPurchased, double price, String deliveryAddress) {
        this.item = item;
        this.seller = seller;
        this.buyer = buyer;
        this.quantityPurchased = quantityPurchased;
        this.price = price;
        this.deliveryAddress = deliveryAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public int getQuantityPurchased() {
        return quantityPurchased;
    }

    public void setQuantityPurchased(int quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}

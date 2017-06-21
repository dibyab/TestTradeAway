package com.thoughtworks.assignment.domain;

import javax.persistence.*;

/**
 * Created by dibyab on 6/21/17.
 */
@Entity
@Table(name = "app_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_sequence")
    @SequenceGenerator( name = "order_sequence",sequenceName = "order_sequence")
    @Column(name = "order_id",nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private Seller seller;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private Buyer buyer;

    @Column(name = "quantity_purchased")
    private int quantityPurchased;

    @Column(name = "price")
    private double price;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    private Order() {
    }

    public Order(Item item, Seller seller, Buyer buyer, int quantityPurchased, double price, String deliveryAddress) {
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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}

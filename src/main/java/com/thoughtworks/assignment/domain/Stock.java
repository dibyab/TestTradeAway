package com.thoughtworks.assignment.domain;

import javax.persistence.*;

/**
 * Created by vrushali on 6/20/17.
 */
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_sequence_generator")
    @SequenceGenerator(name = "stock_sequence_generator", sequenceName = "stock_sequence")
    @Column(name = "stock_id")
    private int id;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private User user;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    private Stock(){}

    public Stock(Item item, User user) {
        this.item = item;
        this.user = user;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

package com.thoughtworks.assignment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vrushali on 6/21/17.
 */
@Entity
@DiscriminatorValue(value = "S")
public class Seller extends User{

    @Column(name = "pan_number")
    private String panNumber;

    @Column(name = "year_experience")
    private int yearExperience;

    @Column(name = "month_experience")
    private int monthExperience;

    @Column(name = "rating")
    private double rating;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Stock> stocks = new HashSet<>();

    protected Seller() {}

    public Seller(String name, String email, String username, String address, String password, long mobile) {
        super(name,email,username,address,password,mobile,UserType.SELLER);
    }

    public void addStock(Stock stock){
        this.stocks.add( stock);
    }

    public void setMonthExperience(int monthExperience) {
        this.monthExperience = monthExperience;
    }

    public void setYearExperience(int yearExperience) {
        this.yearExperience = yearExperience;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public Set<Stock> getStocks() {
        return Collections.unmodifiableSet(stocks);
    }
}

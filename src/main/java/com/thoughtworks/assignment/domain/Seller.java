package com.thoughtworks.assignment.domain;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
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
}
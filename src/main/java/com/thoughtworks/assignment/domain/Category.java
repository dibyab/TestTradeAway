package com.thoughtworks.assignment.domain;

import javax.persistence.*;

/**
 * Created by dibyab on 6/20/17.
 */
@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue()
    private int id;

    public int getId() {
        return id;
    }

    private Category(){} ;

    @Column(name = "categoryName",nullable = false)
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {


        this.categoryName = categoryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;


    }
}

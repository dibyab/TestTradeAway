package com.thoughtworks.assignment.domain;

import javax.persistence.*;
import java.util.List;

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

    private Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    @Column(name = "categoryName", nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Item> items;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

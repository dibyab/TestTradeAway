package com.thoughtworks.assignment.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Item> items = new HashSet<>();

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        item.setCategory( this);
        this.items.add( item);
    }
}

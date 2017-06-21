package com.thoughtworks.assignment.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dibyab on 6/20/17.
 */
@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_sequence")
    @SequenceGenerator( name = "category_sequence",sequenceName = "category_sequence")
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

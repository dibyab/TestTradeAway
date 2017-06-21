package com.thoughtworks.assignment.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vrushali on 6/20/17.
 */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(generator = "items_sequence_generator" , strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "items_sequence_generator", sequenceName = "items_sequence" )
    @Column(name = "item_id")
    private int id;

    private Item() {

    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Column(name = "imageUrl", nullable = true)
    private URL imageUrl;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Stock> stockSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonBackReference
    private Category category;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public URL getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Stock> getStockSet() {
        return this.stockSet;
    }

    public void addStock(Stock stock) {
        this.stockSet.add( stock);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

package com.thoughtworks.assignment.controller.dto;

/**
 * Created by dibyab on 6/20/17.
 */
public class CategoryDTO {

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;

    }

    public String getCategoryName() {
        return categoryName;
    }

    private String categoryName;
}

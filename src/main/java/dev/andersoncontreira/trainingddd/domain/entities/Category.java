package dev.andersoncontreira.trainingddd.domain.entities;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

public class Category {
    public Long id;

    public String categoryName;
    public String description;
    public Blob picture;
    public String categoryID;

    public Set<Product> products;

    public Category() {
        products = new HashSet<>();
    }

    public Category(Long id, String categoryName, String description, Blob picture, String categoryID) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.picture = picture;
        this.categoryID = categoryID;

    }

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Category setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }

    public Blob getPicture() {
        return picture;
    }

    public Category setPicture(Blob picture) {
        this.picture = picture;
        return this;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public Category setCategoryID(String categoryID) {
        this.categoryID = categoryID;
        return this;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Category setProducts(Set<Product> products) {
        this.products = products;
        return this;
    }
}

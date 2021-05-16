package dev.andersoncontreira.trainingddd.domain.entities;

import java.util.HashSet;
import java.util.Set;

public class Category {
    public Long id;

    public String categoryName;
    public String description;
    public String picture;
    public String categoryID;

//    @Relationship(type = "PART_OF", direction = Relationship.INCOMING)
    public Set<Product> products;

    public Category() {
        products = new HashSet<>();
    }

    public Category(Long id, String categoryName, String description, String picture, String categoryID) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.picture = picture;
        this.categoryID = categoryID;

    }
}

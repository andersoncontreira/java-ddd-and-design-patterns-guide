package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "category")
public class Category extends dev.andersoncontreira.trainingddd.domain.entities.Category {

    @Id
    @Column(name = "CategoryID", columnDefinition = "int", nullable = false, length = 11)
    public String categoryID;

    @Column(name = "CategoryName", columnDefinition = "varchar(15)", nullable = false, length = 15)
    @Size(min = 2, max = 15, message = ("Customer.validation.size.CategoryName"))
    public String categoryName;

    @Column(name = "description", columnDefinition = "longtext", nullable = true)
    @Size(min = 2, message = ("Customer.validation.size.Description"))
    public String description;

    @Column(name = "picture", columnDefinition = "longblob", nullable = true)
    public String picture;

}

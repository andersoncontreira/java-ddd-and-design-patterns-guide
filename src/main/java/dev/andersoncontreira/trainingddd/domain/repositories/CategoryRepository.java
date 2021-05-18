package dev.andersoncontreira.trainingddd.domain.repositories;

import dev.andersoncontreira.trainingddd.domain.entities.Category;

import java.util.List;

public interface CategoryRepository {

    Category find(int id);

    List<Category> list();

    boolean create();

    boolean update();

    boolean deleted();

}

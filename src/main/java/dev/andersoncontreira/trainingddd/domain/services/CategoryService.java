package dev.andersoncontreira.trainingddd.domain.services;

import dev.andersoncontreira.trainingddd.domain.entities.Category;
import dev.andersoncontreira.trainingddd.domain.repositories.CategoryRepository;
import org.apache.log4j.Logger;

import java.util.List;

public class CategoryService {

    private final Logger logger;
    private final CategoryRepository repository;

    public CategoryService(Logger logger, CategoryRepository categoryRepository) {
        this.logger = logger;
        this.repository = categoryRepository;
    }
    public List<Category> list() {

        return repository.list();
    }

    public Category find(int id) {
        return repository.find(id);
    }
}

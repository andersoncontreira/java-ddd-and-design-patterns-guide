package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.repositories;


import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.entities.Category;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository extends AbstractRepository<Category> {


    @Autowired
    public CategoryRepository(Logger logger, SessionFactory sessionFactory) {
        this.logger = logger;
        this.sessionFactory = sessionFactory;

    }

    public List<Category> list() {
        return null;
    }

    public Category find() {
        return null;
    }
}

package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.repositories;


import dev.andersoncontreira.trainingddd.domain.entities.Category;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository extends AbstractRepository<Category> implements dev.andersoncontreira.trainingddd.domain.repositories.CategoryRepository {


    @Autowired
    public CategoryRepository(Logger logger, SessionFactory sessionFactory) {
        super(Category.class);
        this.logger = logger;
        this.sessionFactory = sessionFactory;

    }

    @Override
    public Category find(int id) {
        try {
            return super.find(id);
        } catch (NoSuchFieldException e) {
            logger.error(e);
            return null;
        }
    }

    @Override
    public List<Category> list() {

        return null;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean deleted() {
        return false;
    }
}

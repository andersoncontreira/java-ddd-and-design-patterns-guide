package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.repositories;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan("dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.repositories")
public abstract class AbstractRepository<T> {

    protected Class<T> entityClass;

    protected SessionFactory sessionFactory;

    protected Logger logger;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    public AbstractRepository<T> setLogger(Logger logger) {
        this.logger = logger;
        return this;
    }

}

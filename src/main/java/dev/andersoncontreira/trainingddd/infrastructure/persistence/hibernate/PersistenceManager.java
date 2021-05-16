package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate;

import org.hibernate.SessionFactory;

public class PersistenceManager {

    private static PersistenceManager instance;
    private static PersistenceConfiguration persistenceConfiguration;
    private SessionFactory sessionFactory;

    private PersistenceManager(PersistenceConfiguration persistenceConfiguration) {


    }
}

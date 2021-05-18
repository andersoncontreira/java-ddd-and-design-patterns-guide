package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.repositories;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PersistenceException;

/**
 * AbstractRepository - Provide the basic methods for the repositories
 * @param <T>
 */
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

    /**
     * Construtor passando a entidade
     */
    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Open database Session
     * @return
     */
    public Session getSession() {
        return sessionFactory.openSession();
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public T find(Object id) throws NoSuchFieldException, PersistenceException {
        T result = null;
        Session session = getSession();
        session.beginTransaction();

        try {
            result = session.find(entityClass, id);
            session.getTransaction().commit();
        } catch (Exception ex) {
            logger.error(ex.getCause().getMessage());
            logger.error(ex.getMessage(), ex);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

}

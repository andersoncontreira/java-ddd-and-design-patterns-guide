package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate;

import dev.andersoncontreira.trainingddd.domain.entities.Entity;
import dev.andersoncontreira.trainingddd.domain.enums.Timezones;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class SessionFactory {
    private static String HIBERNATE_PROPERTIES = "hibernate.properties";
    public static String PACKAGES_TO_SCAN = String.format("%s.entities",SessionFactory.class.getPackage().toString());

    public static org.hibernate.SessionFactory factory(Configuration configuration, PersistenceConfiguration persistenceConfiguration) {

        Properties properties = generateHibernateProperties(persistenceConfiguration);

        configuration.setProperties(properties);

        /**
         * Read the packages and register the classes
         */
        configuration.addPackage(PACKAGES_TO_SCAN);

        registerEntities(configuration);

        return configuration.buildSessionFactory();
    }

    public static org.hibernate.SessionFactory factory(PersistenceConfiguration persistenceConfiguration) {
        Configuration configuration = new Configuration();
        return factory(configuration, persistenceConfiguration);
    }

    protected static Properties generateHibernateProperties(PersistenceConfiguration persistenceConfiguration) {
        Properties properties = new  Properties();

        String connectionUrlFormat = "jdbc:%s://%s:%d/%s";
        String connectionUrl = String.format(connectionUrlFormat,
                persistenceConfiguration.type,
                persistenceConfiguration.hostname,
                persistenceConfiguration.port,
                persistenceConfiguration.database);


        String type = persistenceConfiguration.type;
        String driver = persistenceConfiguration.driver;

        properties.setProperty("hibernate.connection.password", persistenceConfiguration.password);
        properties.setProperty("hibernate.connection.username", persistenceConfiguration.username);
        properties.setProperty("hibernate.connection.url", connectionUrl);
        properties.setProperty("hibernate.connection.pool_size",
                String.valueOf(persistenceConfiguration.poolSize));

        properties.setProperty("packagesToScan", PACKAGES_TO_SCAN);

        properties.setProperty("hibernate.dialect", getHibernateDialect(type));
        properties.setProperty("hibernate.jdbc.time_zone", Timezones.TZ_AMERICA_SAO_PAULO.getValue());
        properties.setProperty("hibernate.connection.driver_class", getHibernateDriverClass(type, driver));
        properties.setProperty("hibernate.jdbc.time_zone", Timezones.TZ_AMERICA_SAO_PAULO.getValue());
        properties.setProperty("hibernate.show_sql", persistenceConfiguration.showSql.toString());
        /**
         * Locks timeouts 10s
         */
        properties.setProperty("javax.persistence.lock.timeout", "10000");// in miliseconds
        return properties;
    }

    /**
     * Return the database dialect
     * @param type
     * @return
     */
    private static String getHibernateDialect(String type) {
        String dialect;
        switch (type) {
            default:
            case "mysql":
                dialect = "org.hibernate.dialect.MySQLDialect";
                break;
            case "postgre":
                dialect = "org.hibernate.dialect.PostgreSQL9Dialect";
                break;
        }

        return dialect;
    }

    /**
     * Return the hibernate database driver class
     * @param type
     * @param driver
     * @return
     */
    private static String getHibernateDriverClass(String type, String driver) {
        if (!driver.isEmpty()) {
            return driver;
        } else {
            switch (type) {
                default:
                case "mysql":
                    driver = "com.mysql.cj.jdbc.Driver";
                    break;
                case "postgres":
                    driver = "org.postgresql.cj.jdbc.Driver";
                    break;

            }
        }

        return driver;
    }

    private static Set<Class<? extends Entity>> getEntities() {


        Reflections reflections = new Reflections(PACKAGES_TO_SCAN);

        return reflections.getSubTypesOf(Entity.class);

    }

    private static void registerEntities(Configuration configuration) {


        Set<Class<? extends Entity>> entities = getEntities();

        Iterator inter = entities.iterator();
        while (inter.hasNext()) {
            Class entityReference = (Class) inter.next();
            configuration.addAnnotatedClass(entityReference);
        }
    }

}

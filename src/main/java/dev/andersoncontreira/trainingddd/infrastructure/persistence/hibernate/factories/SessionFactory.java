package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.factories;

import dev.andersoncontreira.trainingddd.domain.entities.Entity;
import dev.andersoncontreira.trainingddd.domain.enums.Timezones;
import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.PersistenceConfiguration;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

@org.springframework.context.annotation.Configuration
public class SessionFactory {
    private static String HIBERNATE_PROPERTIES = "hibernate.properties";
    public static String PACKAGES_TO_SCAN = "dev.andersoncontreira.trainingddd.domain.entities";
    public static int MODE_SCAN = 1;
    public static int MODE_MAP = 2;
    public static int MODE = MODE_MAP;

    private PersistenceConfiguration persistenceConfiguration;
    private Configuration configuration;

    public SessionFactory(Configuration configuration, PersistenceConfiguration persistenceConfiguration) {
        this.configuration = configuration;
        this.persistenceConfiguration = persistenceConfiguration;
    }

    @Autowired
    public SessionFactory(PersistenceConfiguration persistenceConfiguration) {
        this.configuration = new Configuration();
        this.persistenceConfiguration = persistenceConfiguration;
    }

    public SessionFactory() {
        this.configuration = new Configuration();
        this.persistenceConfiguration = new PersistenceConfiguration();
    }


    @Bean
    public org.hibernate.SessionFactory factory() {

        Properties properties = generateHibernateProperties(persistenceConfiguration);

        configuration.setProperties(properties);

        /**
         * Read the packages and register the classes
         */
        if (MODE == MODE_SCAN) {
            configuration.addPackage(PACKAGES_TO_SCAN);
            registerEntities(configuration);
        } else {
            Resource[] resources = getEntitiesByMapping();
            for (Resource resource: resources) {
                try {
                    configuration.addFile(resource.getFile());
                } catch (IOException e) {
                    ConsoleLogger.getLogger().error(e);
                }
            }
        }

        return configuration.buildSessionFactory();
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
        properties.setProperty("hibernate.dialect", getHibernateDialect(type));
        properties.setProperty("hibernate.jdbc.time_zone", Timezones.TZ_AMERICA_SAO_PAULO.getValue());
        properties.setProperty("hibernate.connection.driver_class", getHibernateDriverClass(type, driver));
        properties.setProperty("hibernate.jdbc.time_zone", Timezones.TZ_AMERICA_SAO_PAULO.getValue());
        properties.setProperty("hibernate.show_sql", persistenceConfiguration.showSql.toString());
        /**
         * Locks timeouts 10s
         */
        properties.setProperty("javax.persistence.lock.timeout", "10000");// in miliseconds
        /**
         * Scan entities
         */
        if (MODE == MODE_SCAN) {
            properties.setProperty("packagesToScan", PACKAGES_TO_SCAN);
        }

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

    /**
     * Get entities by annotation
     * @return
     */
    private static Set<Class<? extends Entity>> getEntities() {


        Reflections reflections = new Reflections(PACKAGES_TO_SCAN);

        return reflections.getSubTypesOf(Entity.class);

    }


    private static Resource[] getEntitiesByMapping() {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = new Resource[]{};

        try {
            resources = resolver.getResources("classpath:/dev/andersoncontreira/infrastructure/persistence/hibernate/*.hbm.xml");
        } catch (IOException e) {
            //TODO tratar logger
            e.printStackTrace();
        }

        return resources;
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

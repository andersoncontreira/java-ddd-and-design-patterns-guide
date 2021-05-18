package component.dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate;

import component.AbstractComponentTestCase;
import dev.andersoncontreira.trainingddd.application.configuration.Configuration;
import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.PersistenceConfiguration;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.factories.SessionFactory;
import org.junit.jupiter.api.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

class SessionFactoryTest extends AbstractComponentTestCase {

    @BeforeAll
    static void setUpBeforeClass() {

    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void factory() throws ApplicationException {
        Class<?> currentClass = new Object() {}.getClass();
        logger.info(String.format("Running test: %s::%s - %s", getClassName(currentClass), getMethodName(currentClass), null));

        Configuration configuration = Configuration.getConfiguration();
        PersistenceConfiguration persistenceConfiguration = new PersistenceConfiguration(configuration);
        logger.info(persistenceConfiguration.hostname);
        logger.info(persistenceConfiguration.username);
        logger.info(persistenceConfiguration.password);
        logger.info(persistenceConfiguration.database);
        org.hibernate.SessionFactory sessionFactory = new SessionFactory(persistenceConfiguration).factory();

        assertThat(sessionFactory, instanceOf(org.hibernate.SessionFactory.class));
    }

    @Test
    void generateHibernateProperties() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> currentClass = new Object() {}.getClass();
        logger.info(String.format("Running test: %s::%s - %s", getClassName(currentClass), getMethodName(currentClass), null));

        PersistenceConfiguration persistenceConfiguration = new PersistenceConfiguration();
        Method method = SessionFactory.class.getDeclaredMethod("generateHibernateProperties", PersistenceConfiguration.class);
        method.setAccessible(true);
        Properties properties = (Properties) method.invoke(null, persistenceConfiguration);

        logger.info(String.format("Properties: %s", properties.toString()));

        Assertions.assertTrue(properties.containsKey("hibernate.connection.password"));
    }
}
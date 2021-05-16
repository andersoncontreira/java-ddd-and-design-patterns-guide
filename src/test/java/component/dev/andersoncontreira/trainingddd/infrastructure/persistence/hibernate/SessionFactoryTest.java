package component.dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate;

import component.AbstractComponentTestCase;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.PersistenceConfiguration;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.factories.SessionFactory;
import org.junit.jupiter.api.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

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
    void factory() {
        Class<?> currentClass = new Object() {}.getClass();
        logger.info(String.format("Running test: %s::%s - %s", getClassName(currentClass), getMethodName(currentClass), null));
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
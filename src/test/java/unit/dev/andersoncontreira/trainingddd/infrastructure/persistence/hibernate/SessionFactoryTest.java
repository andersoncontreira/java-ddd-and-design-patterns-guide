package unit.dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate;

import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.PersistenceConfiguration;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import unit.AbstractUnitTestCase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test of SessionFactory for Database Connections
 */
class SessionFactoryTest extends AbstractUnitTestCase {

    @BeforeEach
    void setUp() {
    }

    @Test
    void factory() {
        Class<?> currentClass = new Object() {}.getClass();
        logger.info(String.format("Running test: %s::%s - %s", getClassName(currentClass), getMethodName(currentClass), null));

        Configuration configuration = Mockito.mock(Configuration.class);
        Mockito.when(configuration.buildSessionFactory())
                .thenReturn(Mockito.mock(org.hibernate.SessionFactory.class));

        PersistenceConfiguration persistenceConfiguration = new PersistenceConfiguration();
        org.hibernate.SessionFactory sessionFactory = SessionFactory.factory(configuration, persistenceConfiguration);

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
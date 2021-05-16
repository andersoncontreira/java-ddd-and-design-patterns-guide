package unit.dev.andersoncontreira.trainingddd.application.container;

import dev.andersoncontreira.trainingddd.application.configuration.Configuration;
import dev.andersoncontreira.trainingddd.application.container.ApplicationContainer;
import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import unit.AbstractUnitTestCase;

class ApplicationContainerTest extends AbstractUnitTestCase {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void boot() throws ApplicationException {
        Class<?> currentClass = new Object() {}.getClass();
        logger.info(String.format("Running test: %s::%s - %s", getClassName(currentClass), getMethodName(currentClass), null));

        ApplicationContainer container = ApplicationContainer.getInstance();

        /**
         * Mock hibernate
         */
        org.hibernate.cfg.Configuration hibernateConfiguration = Mockito.mock(org.hibernate.cfg.Configuration.class);
        Mockito.when(hibernateConfiguration.buildSessionFactory())
                .thenReturn(Mockito.mock(org.hibernate.SessionFactory.class));
        container.registerSingleton(hibernateConfiguration.getClass().getName(), hibernateConfiguration);
        container.refresh();

        container.boot();

        Logger testLogger = (Logger) container.getBean(Logger.class);
        Configuration configuration = (Configuration) container.getBean(Configuration.class);

        Assertions.assertNotNull(testLogger);
        Assertions.assertNotNull(configuration);

        Assertions.assertTrue(ApplicationContainer.isBooted());
    }
}
package component.dev.andersoncontreira.trainingddd.application.container;

import component.AbstractComponentTestCase;
import dev.andersoncontreira.trainingddd.application.configuration.Configuration;
import dev.andersoncontreira.trainingddd.application.container.ApplicationContainer;
import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationContainerTest extends AbstractComponentTestCase {

    @BeforeEach
    void setUp() {
    }

    @Test
    void boot() throws ApplicationException {
        Class<?> currentClass = new Object() {}.getClass();
        logger.info(String.format("Running test: %s::%s - %s", getClassName(currentClass), getMethodName(currentClass), null));

        ApplicationContainer container = ApplicationContainer.getInstance();
        container.boot();

        Logger testLogger = (Logger) container.getBean(Logger.class);
        Configuration configuration = (Configuration) container.getBean(Configuration.class);

        Assertions.assertNotNull(testLogger);
        Assertions.assertNotNull(configuration);

        Assertions.assertTrue(ApplicationContainer.isBooted());
    }
}
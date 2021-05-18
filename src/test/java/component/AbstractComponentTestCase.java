package component;

import dev.andersoncontreira.trainingddd.application.container.ApplicationContainer;
import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;

public class AbstractComponentTestCase {

    protected static Logger logger;
    protected static ApplicationContainer container;

    @BeforeAll
    public static void setUpClass() throws ApplicationException {
        
        logger = ConsoleLogger.getLogger("component");
        container = ApplicationContainer.getInstance();
        container.boot();
    }

    public String getMethodName(Class<?> currentClass) {
        String methodName = currentClass.getEnclosingMethod().getName();
        return methodName;
    }

    public String getClassName(Class<?> currentClass) {
        String className = currentClass.getEnclosingClass().getSimpleName();
        return className;
    }
}

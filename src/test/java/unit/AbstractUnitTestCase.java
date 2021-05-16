package unit;

import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;

public class AbstractUnitTestCase {

    protected static Logger logger;

    @BeforeAll
    public static void setUpClass() {
        logger = ConsoleLogger.getLogger("unit");
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

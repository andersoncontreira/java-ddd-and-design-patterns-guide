package dev.andersoncontreira.trainingddd.infrastructure.logger;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import static org.apache.log4j.ConsoleAppender.SYSTEM_OUT;

public class ConsoleLogger {

    public static Logger instance = null;

    private static Logger buildInstance(String name) {
        Logger logger = Logger.getLogger(name);

        PatternLayout patternLayout = new PatternLayout("[%p] %d{ISO8601} - %m%n");

        ConsoleAppender consoleAppender = new ConsoleAppender(patternLayout, SYSTEM_OUT);

        logger.addAppender(consoleAppender);

        return logger;
    }

    public static Logger getLogger(Class<?> applicationClass) {
        if (instance == null) {
            instance = buildInstance(applicationClass.getName());
        }
        return instance;
    }

    public static Logger getLogger(String name) {
        if (instance == null) {
            instance = buildInstance(name);
        }
        return instance;
    }

    public static Logger getLogger() {
        if (instance == null) {
            instance = buildInstance("console");
        }
        return instance;
    }

}

package dev.andersoncontreira.trainingddd.application.http.controllers;

import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;
import org.apache.log4j.Logger;

public class AbstractController {

    protected static Logger logger = null;

    public static Logger getLogger() {
        if (logger == null) {
            // TODO temporário
            logger = ConsoleLogger.getLogger();
        }
        return logger;
    }
}

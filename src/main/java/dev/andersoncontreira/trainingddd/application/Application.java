package dev.andersoncontreira.trainingddd.application;

import dev.andersoncontreira.trainingddd.application.configuration.Configuration;
import dev.andersoncontreira.trainingddd.application.container.ApplicationContainer;
import dev.andersoncontreira.trainingddd.application.enums.ApplicationMessages;
import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import dev.andersoncontreira.trainingddd.application.handlers.http.HttpHandler;
import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application of the project
 */
@SpringBootApplication
public class Application {
    /**
     * Application current version
     */
    public static final String APP_VERSION = "1.0.0";
    /**
     * Application current REST version
     */
    public static final String APP_ARCH_VERSION = "v1";
    /**
     * Application name
     */
    public static String APP_NAME = "Training DDD";
    /**
     * HTTP Mode for REST operations
     */
    private static final String HTTP_MODE = "http";
    /**
     * CLI mode for commands and crons operations
     */
    private static final String CLI_MODE = "cli";
    /**
     * Application mode
     */
    public static String MODE = HTTP_MODE;
    /**
     * Default App logger
     */
    public static Logger logger = ConsoleLogger.getLogger();
    /**
     * Application configuration
     */
    private Configuration configuration = null;

    /**
     * Start function
     * @param args
     */
    public static void main(String[] args) {
        Application application = new Application();

        try {
            application.initialize();
            application.boot();
            application.run(args);

        } catch (Exception exception) {
            String errorMessage = exception.getMessage();
            if (errorMessage == null) {
                errorMessage = exception.toString();
            }
            logger.error(errorMessage);
        }

    }



    /**
     * Initialiaze the application
     */
    private void initialize() {

        logger.info("-------------------------------------");
        logger.info(String.format( "%s - %s - Configuration ", APP_NAME, APP_VERSION));
        logger.info("-------------------------------------");


        try {
            configuration = Configuration.getConfiguration();
            logger.info("Application ...");
            logger.info(String.format("environment: %s", configuration.get("environment")));

            logger.info("Database ...");
            logger.info(String.format("driver: %s", configuration.get("persistence.driver")));
            logger.info(String.format("hostname: %s", configuration.get("persistence.hostname")));
            logger.info(String.format("database: %s", configuration.get("persistence.database")));

            logger.info("Server ...");
            logger.info(String.format("type: %s", configuration.get("server.type")));

        } catch (ApplicationException e) {
            exit(e);
        }

    }

    /**
     * Boot the application
     */
    private void boot() {
        logger.info("-------------------------------------");
        logger.info(String.format( "%s - %s - Booting ", APP_NAME, APP_VERSION));
        logger.info("-------------------------------------");

        logger.info("Container ...");
        try {
            ApplicationContainer container = ApplicationContainer.getInstance();
            container.boot();
            //container.refresh(3000);
        } catch (ApplicationException exception) {
            exit(exception);
        }

        logger.info("Database ...");
        ApplicationContainer.getInstance().getBean(SessionFactory.class);
    }

    /**
     * Run the application
     * @param args Application args
     */
    private void run(String[] args) {
        if (MODE.equals(HTTP_MODE)) {
            HttpHandler handler = new HttpHandler(configuration, logger);
            handler.run(Application.class, args);
        } else {
            exit(new ApplicationException(ApplicationMessages.NOT_IMPLEMENTED_YET));
        }
    }

    /**
     * Finish the application by an error
     * @param exception
     */
    private void exit(ApplicationException exception) {
        logger.error("Exiting the application with error:");
        logger.error(exception.getMessage());
        System.exit(exception.getCode());
    }
}
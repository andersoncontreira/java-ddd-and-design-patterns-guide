package dev.andersoncontreira.trainingddd.application.http.server;

import dev.andersoncontreira.trainingddd.application.configuration.Configuration;
import dev.andersoncontreira.trainingddd.application.http.routes.spark.ApiRoutes;
import org.apache.log4j.Logger;

public class Spark implements Server {
    private final Configuration configuration;
    private final Logger logger;

    public Spark(Configuration configuration, Logger logger) {
        this.configuration = configuration;
        this.logger = logger;
    }

    @Override
    public void initialize() {
        int port = Integer.parseInt(configuration.get("server.port"));
        logger.info("Initializing the server");
        logger.info(String.format("port: %d", port));

        spark.Spark.staticFiles.location("/public");

        spark.Spark.port(port);

        routes();
    }

    @Override
    public void filters() {

    }

    @Override
    public void routes() {
        ApiRoutes apiRoutes = new ApiRoutes();
        apiRoutes.mapRoutes();
    }

    @Override
    public void errorHandlers() {

    }

    @Override
    public void run(Class<?> applicationClass, String[] args) {
        run(configuration, applicationClass, args);
    }

    @Override
    public void run(Configuration configuration, Class<?> applicationClass, String[] args) {

        spark.Spark.threadPool(Integer.parseInt(configuration.get("server.maxTreads")));

    }

    @Override
    public void stop() {
        spark.Spark.stop();
    }
}

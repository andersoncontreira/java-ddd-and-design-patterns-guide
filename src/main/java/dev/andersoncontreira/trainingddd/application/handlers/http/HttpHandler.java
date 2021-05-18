package dev.andersoncontreira.trainingddd.application.handlers.http;

import dev.andersoncontreira.trainingddd.application.configuration.Configuration;
import dev.andersoncontreira.trainingddd.application.enums.ServerType;
import dev.andersoncontreira.trainingddd.application.handlers.Handler;
import dev.andersoncontreira.trainingddd.application.http.servers.Server;
import dev.andersoncontreira.trainingddd.application.http.servers.Spark;
import dev.andersoncontreira.trainingddd.application.http.servers.SpringBoot;
import org.apache.log4j.Logger;

public class HttpHandler implements Handler {

    private final Configuration configuration;
    private final Logger logger;

    public HttpHandler(Configuration configuration, Logger logger) {
        this.configuration = configuration;
        this.logger = logger;
    }

    public void run(Class<?> applicationClass, String[] args) {
        String serverTypeStr = configuration.get("server.type");
        ServerType serverType = ServerType.fromType(serverTypeStr);

        if (serverType == null) {
            serverType = ServerType.SPRING_BOOT;
        }

        Server server = new SpringBoot(this.configuration, this.logger);
        if (ServerType.SPARK.equals(serverType)) {
            server = new Spark(this.configuration, this.logger);
        }

        server.initialize();
        server.run(applicationClass, args);
    }


}

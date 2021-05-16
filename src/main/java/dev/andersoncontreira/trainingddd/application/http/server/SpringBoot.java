package dev.andersoncontreira.trainingddd.application.http.server;

import dev.andersoncontreira.trainingddd.application.configuration.Configuration;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

public class SpringBoot implements Server {
    private final Configuration configuration;
    private final Logger logger;

    public SpringBoot(Configuration configuration, Logger logger) {
        this.configuration = configuration;
        this.logger = logger;
    }

    @Override
    public void initialize() {
        routes();
    }

    @Override
    public void filters() {

    }

    @Override
    public void routes() {

    }

    @Override
    public void errorHandlers() {

    }

    @Override
    public void run(Class<?> applicationClass, String[] args) {
        SpringApplication.run(applicationClass, args);
    }


    public void run(Configuration configuration, Class<?> applicationClass, String[] args) {
        logger.info("Starting Server");
        //TODO implementar
        // https://stackoverflow.com/questions/21083170/how-to-configure-port-for-a-spring-boot-application
        Properties properties = new Properties();
        properties.put("server.port", configuration.get("server.port"));
        new SpringApplicationBuilder()
                //.sources() Para mapear com no outro
                .properties(properties)
                .run(args);
    }


    @Override
    public void stop() {

    }
}

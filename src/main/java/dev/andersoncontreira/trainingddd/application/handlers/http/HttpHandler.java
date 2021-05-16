package dev.andersoncontreira.trainingddd.application.handlers.http;

import dev.andersoncontreira.trainingddd.application.configuration.Configuration;
import dev.andersoncontreira.trainingddd.application.handlers.Handler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Properties;

public class HttpHandler implements Handler {

    private final Configuration configuration;

    public HttpHandler(Configuration configuration) {
        this.configuration = configuration;
    }

    public void run(Class<?> applicationClass, String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    public void buildAndRun(Class<?> applicationClass, String[] args) {
        // https://stackoverflow.com/questions/21083170/how-to-configure-port-for-a-spring-boot-application
        Properties properties = new Properties();
        properties.put("server.port", this.configuration.get("server.port"));
        new SpringApplicationBuilder()
                //.sources() Para mapear com no outro
                .properties(properties)
                .run(args);
    }

}

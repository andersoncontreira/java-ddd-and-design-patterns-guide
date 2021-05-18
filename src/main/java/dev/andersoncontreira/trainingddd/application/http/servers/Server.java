package dev.andersoncontreira.trainingddd.application.http.servers;

import dev.andersoncontreira.trainingddd.application.configuration.Configuration;

public interface Server {

    public void initialize();

    void filters();

    void routes();

    void errorHandlers();

    public void run(Class<?> applicationClass, String[] args);

    public void run(Configuration configuration, Class<?> applicationClass, String[] args);

    public void stop();
}

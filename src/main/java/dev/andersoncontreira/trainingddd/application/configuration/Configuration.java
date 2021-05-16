package dev.andersoncontreira.trainingddd.application.configuration;

import dev.andersoncontreira.trainingddd.application.Application;
import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import dev.andersoncontreira.trainingddd.application.loaders.PropertiesLoader;

import java.util.Properties;

/**
 * Application configuration
 */
public class Configuration {
    private static final String DEVELOPMENT = "development";
    private static Configuration instance = null;
    private Properties properties = null;

    public Configuration(Properties properties) {
        this.properties = properties;
    }

    public static Configuration getConfiguration () throws ApplicationException {
        if (instance == null) {
            String environment = System.getenv("APP_ENV");

            if (environment == null || environment.isEmpty()) {
                environment = DEVELOPMENT;
            }

            Properties defaultProperties = new Properties();
            defaultProperties.put("environment", environment);
            defaultProperties.put("app_name", Application.APP_NAME);
            defaultProperties.put("app_version", Application.APP_VERSION);

            Properties properties = PropertiesLoader.load(environment);
            defaultProperties.putAll(properties);

            instance = new Configuration(defaultProperties);
        }
        return instance;
    }

    /**
     * Get one configuration property
     * @param key Property key name
     * @return
     */
    public String get(String key) {

        if (this.properties != null) {
            if (this.properties.containsKey(key)) {
                return this.properties.get(key).toString();
            } else if (this.properties.containsKey(key.toLowerCase())) {
                return this.properties.get(key.toLowerCase()).toString();
            }
        }

        return null;
    }
}

package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.factories;

import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.PersistenceConfiguration;

/**
 * Build an instance of Persistence Configuration
 */

public class PersistenceConfigurationFactory {

    private dev.andersoncontreira.trainingddd.application.configuration.Configuration configuration;


    public void setConfiguration(dev.andersoncontreira.trainingddd.application.configuration.Configuration configuration) {
        this.configuration = configuration;
    }


    public PersistenceConfiguration factory() {
        return new PersistenceConfiguration(this.configuration);
    }
}

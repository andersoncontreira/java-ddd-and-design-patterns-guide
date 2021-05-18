package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.factories;

import dev.andersoncontreira.trainingddd.application.configuration.Configuration;
import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.PersistenceConfiguration;

/**
 * Build an instance of Persistence Configuration
 */

public class PersistenceConfigurationFactory {

    private Configuration configuration;

    public PersistenceConfigurationFactory(Configuration configuration) throws ApplicationException {
        this.configuration = configuration;
    }
    public PersistenceConfigurationFactory() throws ApplicationException {
        this.configuration = Configuration.getConfiguration();
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }


    public PersistenceConfiguration factory() {
        return new PersistenceConfiguration(this.configuration);
    }
}

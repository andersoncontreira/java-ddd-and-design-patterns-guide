package dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.factories;

import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.PersistenceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Build an instance of Persistence Configuration
 */
@Configuration
public class PersistenceConfigurationFactory {

    private final dev.andersoncontreira.trainingddd.application.configuration.Configuration configuration;

    @Autowired
    public PersistenceConfigurationFactory(dev.andersoncontreira.trainingddd.application.configuration.Configuration configuration) {
        this.configuration = configuration;
    }
    @Bean
    public PersistenceConfiguration factory() {
        return new PersistenceConfiguration(this.configuration);
    }
}

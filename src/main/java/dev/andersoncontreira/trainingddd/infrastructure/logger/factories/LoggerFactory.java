package dev.andersoncontreira.trainingddd.infrastructure.logger.factories;

import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerFactory {

    @Bean
    public Logger factory() {
        return ConsoleLogger.getLogger("console");
    }
}

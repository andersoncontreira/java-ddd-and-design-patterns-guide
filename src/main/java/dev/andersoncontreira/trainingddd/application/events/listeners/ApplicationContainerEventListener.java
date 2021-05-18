package dev.andersoncontreira.trainingddd.application.events.listeners;

import dev.andersoncontreira.trainingddd.application.container.ApplicationContainer;
import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContainerEventListener implements ApplicationListener<ApplicationContextEvent> {

    @EventListener
    public void handleContextRefreshEvent(ContextRefreshedEvent event) {
        ConsoleLogger.getLogger().info(String.format("%s received.", event.getClass().getSimpleName()));
        ApplicationContainer.getInstance().setRefreshing(false);
    }

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        ConsoleLogger.getLogger().info(String.format("%s received.", event.getClass().getSimpleName()));

        if (event instanceof ContextRefreshedEvent) {
            ApplicationContainer.getInstance().setRefreshing(false);
        }

    }
}

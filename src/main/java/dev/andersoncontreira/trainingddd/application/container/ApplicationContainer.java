package dev.andersoncontreira.trainingddd.application.container;

import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.PersistenceConfiguration;
import org.apache.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * Application Container
 */
public class ApplicationContainer {

    private static ApplicationContainer instance;
    private static boolean booted = false;

    private final AnnotationConfigApplicationContext context;
    private final DefaultListableBeanFactory beanFactory;
    private final Logger logger;

    private ApplicationContainer() {
        beanFactory = new DefaultListableBeanFactory();
        context = new AnnotationConfigApplicationContext(beanFactory);
        logger = ConsoleLogger.getLogger();
    }

    public static ApplicationContainer getInstance() {
        if (instance == null) {
            instance = new ApplicationContainer();
        }
        return instance;
    }

    public static boolean isBooted() {
        return booted;
    }

    public void boot() throws ApplicationException {
        /**
         * Register log
         */
        beanFactory.registerSingleton(Logger.class.getName(), logger);
        /**
         * Basic Configurations
         */
        bootConfigurations();
        /**
         * @Configuration Classes
         */
        Set<Class<?>> classList = getAnnotatedClassList(Configuration.class);

        logger.info("Registering Configuration classes");
        for (Class<?> configClass : classList) {
            logger.debug(String.format("Registering ... %s", configClass.getName()));

            context.register(configClass);
        }

        try {
            refresh();
        } catch (Exception exception) {
            logger.error(exception);
        }




        booted = true;

    }

    private void bootConfigurations() throws ApplicationException {
        dev.andersoncontreira.trainingddd.application.configuration.Configuration configuration =
                dev.andersoncontreira.trainingddd.application.configuration.Configuration.getConfiguration();
        /**
         * Register the basic config
         */
        beanFactory.registerSingleton(configuration.getClass().getName(), configuration);
        /**
         * Register the persistence config
         */
        PersistenceConfiguration persistenceConfiguration = new PersistenceConfiguration(configuration);
        beanFactory.registerSingleton(PersistenceConfiguration.class.getName(), persistenceConfiguration);

//        refresh();

    }

    private Set<Class<?>> getAnnotatedClassList(final Class<? extends Annotation> annotation) {
        String currentPackage = getClass().getPackage().getName().replace(".application.container", "");

        ConfigurationBuilder config = new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(currentPackage))
                .setScanners(new SubTypesScanner(), new TypeAnnotationsScanner());

        Reflections reflections = new Reflections(config);
        return reflections.getTypesAnnotatedWith(annotation);
    }

    public Object getBean(Class<?> requiredType) {
        return getInstance().context.getBean(requiredType);
    }

    public Object getBean(String alias) {
        return getInstance().context.getBean(alias);
    }

    public void registerSingleton(String alias, Object reference) {
        registerSingleton(alias, reference, false);
    }

    public void registerSingleton(String alias, Object reference, Boolean refresh) {
        Boolean isRegistered;
        try {
            isRegistered = null != beanFactory.getBean(alias);
        } catch (Exception e) {
            isRegistered = true;
        }

        if (!isRegistered) {
            beanFactory.registerSingleton(alias, reference);
        }

        if (refresh) {
            refresh();
        }
    }

    public void register(Class<?>... annotatedClasses) {
        context.register(annotatedClasses);
        refresh();
    }

    public void refresh() {
        try {
            context.refresh();
        } catch (Exception exception) {
//            logger.error(exception);
        }
    }
}

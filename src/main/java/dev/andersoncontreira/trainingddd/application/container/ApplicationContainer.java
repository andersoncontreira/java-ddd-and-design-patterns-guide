package dev.andersoncontreira.trainingddd.application.container;

import dev.andersoncontreira.trainingddd.application.events.listeners.ApplicationContainerEventListener;
import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.PersistenceConfiguration;
import dev.andersoncontreira.trainingddd.infrastructure.persistence.hibernate.factories.SessionFactory;
import org.apache.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Annotation;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Application Container
 */
public class ApplicationContainer {

    private static ApplicationContainer instance;
    private static boolean booted = false;
    private static int refreshCounter = 0;

    private final AnnotationConfigApplicationContext context;
    private final DefaultListableBeanFactory beanFactory;
    private final Logger logger;
    private boolean isRefreshing = false;

    private ApplicationContainer() {
        beanFactory = new DefaultListableBeanFactory();
        context = new AnnotationConfigApplicationContext(beanFactory);
        context.addApplicationListener(new ApplicationContainerEventListener());

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
         * Basic Configurations
         */
        bootConfigurations();
        //refresh();
        //waitRefresh(1000);

        /**
         * @Configuration Classes
         */
        bootAnnotatedClasses(Configuration.class);
        //refresh(3000);
        //waitRefresh();

        /**
         * @Repository Classes
         */
        bootAnnotatedClasses(Repository.class);
        //refresh(3000);
        //refresh();

        refresh();
        waitRefresh(3000);
        booted = true;

    }



    private void bootAnnotatedClasses(final Class<? extends Annotation> annotation) {
        Set<Class<?>> classList = getAnnotatedClassList(annotation);

        logger.info(String.format("Registering %s classes", annotation.getSimpleName()));
        for (Class<?> configClass : classList) {
            logger.debug(String.format("Registering ... %s", configClass.getName()));
            try {
                context.register(configClass);
            } catch (Exception exception) {
                logger.error(exception);
            }

        }

        //refresh();
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

        logger.info("Configurations registered");
        try {
            org.hibernate.SessionFactory sessionFactory = new SessionFactory(persistenceConfiguration).factory();
            beanFactory.registerSingleton(org.hibernate.SessionFactory.class.getName(), sessionFactory);
            logger.info("SessionFactory registered");
        } catch(Exception exception) {
            logger.error("Database exception");
            logger.error(exception);
        }

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
        refresh(0);
    }

    public void refresh(long sleepTime) {
        try {
            if (!isRefreshing) {
                logger.info("Refreshing context...");
                isRefreshing = true;
                refreshCounter = 0;
                context.refresh();
//                logger.info(String.format("waiting... %s", sleepTime));
                //Thread.sleep(sleepTime);
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            }
        } catch (Exception exception) {
            isRefreshing = false;
            logger.error(exception);
        }
    }

    private void waitRefresh(int timeout) {
        try {
            logger.info(String.format("waitRefresh: %s", timeout));
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public boolean isRefreshing() {
        return isRefreshing;
    }

    public void setRefreshing(boolean refreshing) {
        logger.info(String.format("setRefreshing: %s", refreshing));
        isRefreshing = refreshing;
    }

}

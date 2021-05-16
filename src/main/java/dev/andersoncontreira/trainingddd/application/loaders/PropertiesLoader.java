package dev.andersoncontreira.trainingddd.application.loaders;

import dev.andersoncontreira.trainingddd.application.enums.ApplicationMessages;
import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import dev.andersoncontreira.trainingddd.application.exceptions.InvalidArgumentException;
import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties load(String fileName) throws ApplicationException {

        if (fileName == null || fileName.isEmpty()) {
            throw new InvalidArgumentException(ApplicationMessages.UNABLE_TO_LOAD_PROPERTIES_FILE.getMessage(fileName));
        }

        if (!fileName.contains(".properties")) {
            fileName += ".properties";
        }

        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName);

        try {

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                //Ops
                FileInputStream fileInputStream = new FileInputStream(fileName);
                properties.load(fileInputStream);
                fileInputStream.close();

                if (properties.isEmpty()) {
                    String errorMessage = ApplicationMessages.UNABLE_TO_LOAD_PROPERTIES_FILE.getMessage(fileName);
                    throw new FileNotFoundException(errorMessage);
                }

            }

        } catch (Exception e) {
            String[] args = {e.getMessage()};
            String errorMessage = ApplicationMessages.UNABLE_TO_LOAD_PROPERTIES_FILE.getMessage(args);
            throw new InvalidArgumentException(errorMessage);

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    ConsoleLogger.getLogger().error(e.getMessage());
//                    e.printStackTrace();
                }
            }
        }

        return properties;
    }
}

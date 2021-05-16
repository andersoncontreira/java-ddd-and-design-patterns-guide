package dev.andersoncontreira.trainingddd.application.exceptions;

import dev.andersoncontreira.trainingddd.application.enums.ApplicationMessages;

public class ApplicationException extends AbstractException {


    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(ApplicationMessages messagesEnum) {
        super(messagesEnum);
    }
}

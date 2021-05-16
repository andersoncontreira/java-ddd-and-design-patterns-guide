package dev.andersoncontreira.trainingddd.application.exceptions;

import dev.andersoncontreira.trainingddd.application.enums.ApplicationMessages;

public class InvalidArgumentException extends ApplicationException {


    public InvalidArgumentException(String message) {
        super(message);
    }

    public InvalidArgumentException(ApplicationMessages messagesEnum) {
        super(messagesEnum);
    }
}

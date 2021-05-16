package dev.andersoncontreira.trainingddd.application.exceptions;

import dev.andersoncontreira.trainingddd.application.enums.ApplicationMessages;

import static dev.andersoncontreira.trainingddd.application.enums.ApplicationMessages.INVALID_ARGUMENTS_INFORMED;

public abstract class AbstractException extends Exception {

    private String[] arguments;

    private String realMessage;

    private int code = 0;

    private String label = INVALID_ARGUMENTS_INFORMED.getLabel();

    public AbstractException(String message) {
        super(message);
        this.arguments = new String[]{};
        this.realMessage = getMessage();
    }

    public AbstractException(ApplicationMessages messagesEnum) {
        super(messagesEnum.getMessage());
        this.arguments = new String[]{messagesEnum.getMessage()};
        this.realMessage = getMessage();
        this.code = messagesEnum.getCode();
        this.label = messagesEnum.getLabel();
    }

    public String[] getArguments() {
        return arguments;
    }

    public String getRealMessage() {
        return realMessage;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
}

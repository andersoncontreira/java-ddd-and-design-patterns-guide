package dev.andersoncontreira.trainingddd.application.enums;

import dev.andersoncontreira.trainingddd.application.utils.ObjectUtils;

public enum ApplicationMessages implements CommonMessages{
    /**
     * Common messages
     * Default Success Messages code between 1 - 10
     */
    SUCCESS_MESSAGE(2, "Success", "common.success"),

    /**
     * 11 - 29
     * Internal erros
     */
    NOT_IMPLEMENTED_YET(11, "Not implemented yet", "erros.not_implemented_yet"),
    /**
     * Errors
     * Messages code between 30 - 99
     */
    INVALID_ARGUMENTS_INFORMED(30, "Invalid Arguments", "error.invalid_arguments_informed"),
    UNABLE_TO_LOAD_PROPERTIES_FILE(31, "Unable to load properties file: %s", "error.unable_to_load_properties_file"),
    UNABLE_TO_LOAD_CONFIGURATION_FILE(32, "Unable to load configuration file: %s", "error.unable_to_load_configuration_file"),

    /**
        * Unknown
     */
    UNKNOWN_ERROR(999, "Unknown error", "error.unknown_error");


    private final int code;
    private String message;
    private String label;

    ApplicationMessages(int code, String message, String label) {
        this.code = code;
        this.message = message;
        this.label = label;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
    public String getMessage(String... params) {
        if (ObjectUtils.isArray(params)) {
            this.message = String.format(this.message, (Object[]) params);
        } else {
            this.message = String.format(this.message, (Object) params);
        }

        return message;
    }

    public ApplicationMessages setMessage(String message) {
        this.message = message;
        return this;
    }
    public ApplicationMessages setParams(Object... params) {
        this.message = String.format(this.message, params);
        return this;
    }


    @Override
    public String getLabel() {
        return label;
    }

    public ApplicationMessages setLabel(String label) {
        this.label = label;
        return this;
    }

    public static ApplicationMessages fromCode(Integer code) {
        for (ApplicationMessages message : ApplicationMessages.values()) {
            if (message.code == code) {
                return message;
            }
        }
        return null;
    }

}

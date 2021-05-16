package dev.andersoncontreira.trainingddd.application.enums;

public enum ServerType {

    SPRING_BOOT("SpringBoot"),
    SPARK("Spark");

    private String type;

    ServerType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static ServerType fromType(String type) {
        for (ServerType serverType : ServerType.values()) {
            if (serverType.type.equals(type)) {
                return serverType;
            }
        }
        return null;
    }
}

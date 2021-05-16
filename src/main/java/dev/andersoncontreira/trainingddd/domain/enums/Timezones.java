package dev.andersoncontreira.trainingddd.domain.enums;

public enum Timezones {
    TZ_UTC("UTC"),
    TZ_AMERICA_SAO_PAULO("America/Sao_Paulo"),
    TZ_AMERICA_LOS_ANGELES("America/Los_Angeles");

    private final String value;

    Timezones(String zone) {
        this.value = zone;
    }

    public String getValue() {
        return value;
    }

    public static Timezones fromValue(String value) {

        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }

        for (Timezones enumEntry : Timezones.values()) {
            if (enumEntry.value.toLowerCase().equals(value.toLowerCase())) {
                return enumEntry;
            }
        }

        throw new IllegalArgumentException("Cannot create TimeZoneId from " + value + " ID!");
    }
}

package dev.andersoncontreira.trainingddd.application.utils;

public class ObjectUtils {
    public static boolean isArray(Object obj)
    {
        return obj!=null && obj.getClass().isArray();
    }
}

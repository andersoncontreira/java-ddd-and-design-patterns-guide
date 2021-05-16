package dev.andersoncontreira.trainingddd.application.utils;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ObjectUtils {
    public static boolean isArray(Object obj)
    {
        return obj!=null && obj.getClass().isArray();
    }

    public static String object2String(Object object) {
        return object2String(object, ToStringStyle.DEFAULT_STYLE);
    }

    public static String object2String(Object object, ToStringStyle style) {

        return ToStringBuilder.reflectionToString(object, style);

    }

    public static String object2Json(Object object) {

        return ToStringBuilder.reflectionToString(object, ToStringStyle.JSON_STYLE);

    }

    public static void print(Object object) {
        printAsJson(object);
    }

    public static void printDefaultStyle(Object object) {
        System.out.println(object2String(object));
    }

    public static void printInSimpleFormat(Object object) {
        System.out.println(object2String(object, ToStringStyle.SIMPLE_STYLE));
    }

    public static void printWithPrefixes(Object object) {
        System.out.println(object2String(object, ToStringStyle.SHORT_PREFIX_STYLE));
    }

    public static void printAsJson(Object object) {
        System.out.println(object2String(object, ToStringStyle.JSON_STYLE));
    }
}

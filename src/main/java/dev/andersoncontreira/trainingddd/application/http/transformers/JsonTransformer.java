package dev.andersoncontreira.trainingddd.application.http.transformers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import dev.andersoncontreira.trainingddd.infrastructure.logger.ConsoleLogger;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonTransformer {

    public String transform(Object model) throws UnsupportedEncodingException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8));
        gson.toJson(model, Object.class, writer);
        try {
            writer.close();
        } catch (IOException e) {
            //e.printStackTrace();
            ConsoleLogger.getLogger().error(e.getMessage());
        }

        return out.toString(StandardCharsets.UTF_8.name());
    }
}

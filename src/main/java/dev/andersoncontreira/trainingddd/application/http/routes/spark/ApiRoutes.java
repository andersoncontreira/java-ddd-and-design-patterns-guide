package dev.andersoncontreira.trainingddd.application.http.routes.spark;

import dev.andersoncontreira.trainingddd.application.http.controllers.ApiController;
import dev.andersoncontreira.trainingddd.application.http.transformers.JsonTransformer;

import java.util.ArrayList;
import java.util.List;

public class ApiRoutes {

    private List<String> routes = new ArrayList<>();

    public void mapRoutes() {

        JsonTransformer transformer = new JsonTransformer();

        routes.add("GET /");
        spark.Spark.get("/", "application/json", (request, response) -> {
            response.type("application/json");
            return ApiController.index();
        }, transformer::transform);

        routes.add("GET /alive");
        spark.Spark.get("/alive", "application/json", (request, response) -> {
            response.type("application/json");
            return ApiController.alive();
        }, transformer::transform);

    }
}

package dev.andersoncontreira.trainingddd.application.http.controllers;

import dev.andersoncontreira.trainingddd.application.configuration.Configuration;
import dev.andersoncontreira.trainingddd.application.exceptions.ApplicationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static dev.andersoncontreira.trainingddd.application.Application.APP_NAME;
import static dev.andersoncontreira.trainingddd.application.Application.APP_VERSION;

/**
 * Basic API Controller
 */
@RestController
public class ApiController extends AbstractController {

    @RequestMapping("/")
    public static Map<String, ?> index() {
        HashMap<String, String> body = new HashMap<>();
        body.put("app", String.format("%s:%s", APP_NAME, APP_VERSION));
        try {
            body.put("server", Configuration.getConfiguration().get("server.type"));
        } catch (ApplicationException exception) {
            exception.printStackTrace();
        }

        return body;
    }

    @GetMapping("/alive")
    public static Map<String, ?> alive() {
        HashMap<String, String> body = new HashMap<>();
        body.put("alive", "I am alive");
        return body;

    }


}

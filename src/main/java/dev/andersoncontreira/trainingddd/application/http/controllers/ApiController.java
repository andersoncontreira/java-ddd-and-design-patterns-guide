package dev.andersoncontreira.trainingddd.application.http.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static dev.andersoncontreira.trainingddd.application.Application.APP_NAME;
import static dev.andersoncontreira.trainingddd.application.Application.APP_VERSION;

@RestController
public class ApiController extends AbstractController {

    @RequestMapping("/")
    public static Map<String, ?> index() {
          HashMap<String, String> body = new HashMap<>();
          body.put("app", String.format("%s:%s", APP_NAME, APP_VERSION));
          return body;
          //https://stackoverflow.com/questions/64735088/how-to-return-json-response-in-springboot
          //TODO temporário
//          JsonTransformer transformer = new JsonTransformer();
//          try {
//              String json = transformer.transform(body);
//              return json;
//          } catch (UnsupportedEncodingException e) {
//              //e.printStackTrace();
//              //TODO tratar
//              return null;
//          }

      }
//    public static String index(Request request, Response response) {
//
//        ApiResponse apiResponse = new ApiResponse(request, response);
//        apiResponse.setResult("OK");
//
//        return apiResponse.json();
//    }
}

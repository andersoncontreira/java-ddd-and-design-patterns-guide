package dev.andersoncontreira.trainingddd.application.http.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class SwaggerController extends AbstractController {

    @GetMapping("/docs")
    public RedirectView index() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/docs/index.html");
        return redirectView;
    }
    @GetMapping("/docs/")
    public RedirectView docs() {
        return index();
    }
}

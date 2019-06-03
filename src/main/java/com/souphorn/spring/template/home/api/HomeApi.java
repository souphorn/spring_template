package com.souphorn.spring.template.home.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApi {
    @GetMapping("/")
    public String index() {
        return "home";
    }
}

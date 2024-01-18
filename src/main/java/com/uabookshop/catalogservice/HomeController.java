package com.uabookshop.catalogservice;

import com.uabookshop.catalogservice.config.UAbookshopProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final UAbookshopProperties uAbookshopProperties;

    public HomeController(UAbookshopProperties uAbookshopProperties) {
        this.uAbookshopProperties = uAbookshopProperties;
    }


    @GetMapping("/hello")
    public String getGreeting() {
        return uAbookshopProperties.getGreeting();    }
}

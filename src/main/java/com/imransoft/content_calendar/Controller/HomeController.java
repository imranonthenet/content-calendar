package com.imransoft.content_calendar.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${cc.welcomeMessage}")
    private String welcomeMessage;

    @GetMapping("/")
    public String hello(){
        return welcomeMessage;
    }
}

package com.utube.notificationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class GreetingController {
    @GetMapping("/")
    public String Greeting() {
        return "Hello!";
    }
}

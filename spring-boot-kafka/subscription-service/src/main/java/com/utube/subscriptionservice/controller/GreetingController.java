package com.utube.subscriptionservice.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class GreetingController {
    @GetMapping("/")
    public String Greeting() {
        return "Hello!";
    }
}

package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")  // Sets the base path
public class HelloService {
    @GetMapping  // Handles GET requests to "/"
    public String hello() {
        return "Hello, World!";
    }
}

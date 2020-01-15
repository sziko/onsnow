package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.app", "com.controller", "com.service"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

package com.boot.handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2017/6/9.
 */
@RestController
@SpringBootApplication
public class Ch522Application {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch522Application.class, args);
    }
}

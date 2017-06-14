package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by Admin on 2017/6/14.
 */
@SpringBootApplication
@EnableCaching
public class Ch853Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch853Application.class, args);
    }
}

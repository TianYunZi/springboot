package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Admin on 2017/8/11.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class Ch655Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch655Application.class, args);
    }
}

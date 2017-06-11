package com.boot;

import com.boot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by XJX on 2017/6/9.
 */
@RestController
@SpringBootApplication
public class Ch65Application {

    @Autowired
    public HelloService helloService;

    @RequestMapping("/")
    public String index() {
        return helloService.sayHello();
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch65Application.class, args);
    }
}

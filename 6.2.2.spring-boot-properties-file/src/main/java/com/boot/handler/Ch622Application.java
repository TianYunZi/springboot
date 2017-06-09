package com.boot.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2017/6/9.
 * 常规属性配置
 */
@RestController
@SpringBootApplication
public class Ch622Application {

    //application.properties--spring boot默认配置文件
    @Value("${book.author}")
    private String bookAuthor;

    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/")
    public String index() {
        return "book name is:" + bookName + " and book author is:" + bookAuthor;
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch622Application.class, args);
    }
}

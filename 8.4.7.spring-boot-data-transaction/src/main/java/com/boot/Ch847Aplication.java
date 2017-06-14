package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by XJX on 2017/6/13.
 */
@SpringBootApplication
@EnableCaching//开启缓存支持
public class Ch847Aplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch847Aplication.class, args);
    }
}

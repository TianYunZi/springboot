package com.boot.handler;

import com.boot.config.DiConfig;
import com.boot.service.UserFunctionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Admin on 2017/6/6.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
        UserFunctionService userFunctionService = context.getBean(UserFunctionService.class);
        System.out.println(userFunctionService.sayHello("world"));
        context.close();
    }
}

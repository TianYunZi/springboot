package com.boot.config;

import com.boot.service.FunctionService;
import com.boot.service.FunctionServiceImpl;
import com.boot.service.UserFunctionService;
import com.boot.service.UserFunctionServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Admin on 2017/6/6.
 */
@Configuration
public class JavaConfig {

    @Bean
    public FunctionService functionService() {
        return new FunctionServiceImpl();
    }

    @Bean
    public UserFunctionService userFunctionService() {
        UserFunctionService userFunctionService = new UserFunctionServiceImpl();
        userFunctionService.setFunctionService(functionService());
        return userFunctionService;
    }
}

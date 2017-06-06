package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/6/6.
 */
public class UserFunctionServiceImpl implements UserFunctionService {

    FunctionService functionService;

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    @Override
    public String sayHello(String world) {
        return functionService.sayHello(world);
    }
}

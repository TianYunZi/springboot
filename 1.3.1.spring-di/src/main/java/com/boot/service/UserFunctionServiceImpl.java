package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/6/6.
 */
@Service
public class UserFunctionServiceImpl implements UserFunctionService {

    @Autowired
    FunctionService functionService;

    @Override
    public String sayHello(String world) {
        return functionService.sayHello(world);
    }
}

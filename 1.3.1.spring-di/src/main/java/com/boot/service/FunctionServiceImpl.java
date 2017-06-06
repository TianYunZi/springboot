package com.boot.service;

import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/6/6.
 */
@Service
public class FunctionServiceImpl implements FunctionService {
    @Override
    public String sayHello(String world) {
        return "Hello " + world + " !";
    }
}

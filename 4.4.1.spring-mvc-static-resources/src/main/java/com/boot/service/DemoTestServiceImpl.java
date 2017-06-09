package com.boot.service;

import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/6/9.
 * 用于测试
 */
@Service
public class DemoTestServiceImpl implements DemoTestService {
    @Override
    public String saySomething() {
        return "hello";
    }
}

package com.boot.service;

import com.boot.annotation.Action;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/6/6.
 * 使用注解的被拦截类
 */
@Service
public class DemoAnnotationServiceImpl implements DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    @Override
    public void add() {

    }
}

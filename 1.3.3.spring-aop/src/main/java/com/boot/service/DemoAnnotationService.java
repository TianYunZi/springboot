package com.boot.service;

import com.boot.annotation.Action;

/**
 * Created by Admin on 2017/6/6.
 */
public interface DemoAnnotationService {

    @Action(name = "注解式拦截的add操作")
    void add();
}

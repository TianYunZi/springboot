package com.boot.controller;

import com.boot.service.DemoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2017/6/9.
 * 编写RestController测试控制器
 */
@RestController
public class MyRestTestController {

    @Autowired
    public DemoTestService demoTestService;

    @RequestMapping(value = "/testRest", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String testRest() {
        return demoTestService.saySomething();
    }
}

package com.boot.controller;

import com.boot.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Admin on 2017/8/11.
 */
@Controller
public class AopController {

    @Autowired
    private AopService aopService;

    @ResponseBody
    @RequestMapping(path = "/api/v1/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String helloAop() {
        aopService.sayHello();
        return "{\"Success\":\"OK\"}";
    }

}

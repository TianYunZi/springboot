package com.boot.controller;

import com.boot.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2017/6/12.
 * 控制器
 */
@RestController
public class Ch773Controller {

    @RequestMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName) {
        return new Person(personName, 32, "hefei");
    }
}

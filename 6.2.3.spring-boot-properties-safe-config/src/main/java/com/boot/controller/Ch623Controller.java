package com.boot.controller;

import com.boot.model.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2017/6/9.
 */
@RestController
public class Ch623Controller {

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    private String index() {
        return "author name is " + authorSettings.getName() + " and author age is" + authorSettings.getAge();
    }
}

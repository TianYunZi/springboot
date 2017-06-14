package com.boot.controller;

import com.boot.dao.PersonDAO;
import com.boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2017/6/14.
 */
@RestController
public class DataController {

    @Autowired
    private PersonDAO personDAO;

    @RequestMapping("/set")
    public void set() {
        Person person = new Person("1", "wyf", 32);
        personDAO.save(person);
        personDAO.stringRedisTemplateDemo();
    }

    @RequestMapping("/getStr")
    public String getStr() {
        return personDAO.getString();
    }

    @RequestMapping("/getPerson")
    public Person getPerson() {
        return personDAO.getPerson();
    }
}

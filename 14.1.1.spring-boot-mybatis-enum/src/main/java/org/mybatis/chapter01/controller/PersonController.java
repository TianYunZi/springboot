package org.mybatis.chapter01.controller;

import org.mybatis.chapter01.dao.PersonMapper;
import org.mybatis.chapter01.enums.PersonType;
import org.mybatis.chapter01.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 2017/12/7.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping(value = "/api/v1/query", method = RequestMethod.GET)
    public List<Person> query() {
        List<Person> list = personMapper.query();
        for (Person p : list) {
            System.out.println(p.toString());
        }
        return list;
    }

    @RequestMapping(value = "/api/v1/select", method = RequestMethod.GET)
    public List<Person> select(@RequestParam("type") String type) {
        List<Person> people = personMapper.select(type);
        for (Person person : people) {
            System.out.println(person.toString());
        }
        return people;
    }
}

package com.boot.controller;

import com.boot.dao.PersonMapper;
import com.boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2017/7/7.
 */
@RestController
@RequestMapping("/person")
public class ProductController {

    @Autowired
    private PersonMapper personMapper;

    @GetMapping("/{id}")
    public Person getPersonInfo(@PathVariable("id") int personId) {

        return personMapper.select(personId);
    }

    @PutMapping("/{id}")
    public Person updatePersonId(@PathVariable("id") long personId, @RequestBody Person newPerson) {
        personMapper.update(newPerson);
        return newPerson;
    }
}

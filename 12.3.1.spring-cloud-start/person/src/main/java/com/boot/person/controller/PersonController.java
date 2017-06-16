package com.boot.person.controller;

import com.boot.person.dao.PersonRepository;
import com.boot.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Admin on 2017/6/16.
 */
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Person> savePerson(@RequestBody String  personName) {
        Person p = new Person(personName);
        personRepository.save(p);
        List<Person> people = personRepository.findAll(new PageRequest(0, 10)).getContent();
        return people;
    }
}

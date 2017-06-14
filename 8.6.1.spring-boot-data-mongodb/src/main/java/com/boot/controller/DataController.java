package com.boot.controller;

import com.boot.dao.PersonRepository;
import com.boot.model.Location;
import com.boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Admin on 2017/6/14.
 */
@RestController
public class DataController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save() {
        Person person = new Person("wyf", 32);
        Collection<Location> locations = new LinkedHashSet<>();
        Location location1 = new Location("上海", "2009");
        Location location2 = new Location("合肥", "2010");
        Location location3 = new Location("上海", "2011");
        Location location4 = new Location("上海", "2012");
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        locations.add(location4);
        person.setLocations(locations);
        return personRepository.save(person);
    }

    @RequestMapping("/q1")
    public Person q1(String name) {
        return personRepository.findByName(name);
    }

    @RequestMapping("/q2")
    public List<Person> q2(Integer age) {
        return personRepository.withQueryFindByAge(age);
    }
}

package com.boot.service;

import com.boot.model.Person;

/**
 * Created by Admin on 2017/6/14.
 */
public interface DemoService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);
}

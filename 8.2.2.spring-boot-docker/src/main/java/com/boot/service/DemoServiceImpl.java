package com.boot.service;

import com.boot.dao.PersonRepository;
import com.boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/6/14.
 * 实现类{@link DemoService}
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person save(Person person) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Person findOne(Person person) {
        return null;
    }
}

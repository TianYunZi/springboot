package com.boot.service;

import com.boot.model.Person;

/**
 * Created by XJX on 2017/6/13.
 */
public interface DemoService {

    Person savePersonWithRollBack(Person person);

    Person savePersonWithoutRollBack(Person person);
}

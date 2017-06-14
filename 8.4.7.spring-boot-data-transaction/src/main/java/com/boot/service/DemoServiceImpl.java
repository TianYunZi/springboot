package com.boot.service;

import com.boot.dao.PersonRepository;
import com.boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by XJX on 2017/6/13.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(rollbackFor = {Throwable.class})
    @Override
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if (p.getName().equals("汪云飞")) {
            throw new IllegalArgumentException("汪云飞已存在，数据将回滚");
        }
        return p;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if (p.getName().equals("汪云飞")) {
            throw new IllegalArgumentException("汪云飞已存在，数据将不会回滚");
        }
        return p;
    }
}

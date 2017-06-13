package com.boot.controller;

import com.boot.dao.PersonRepository;
import com.boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 2017/6/13.
 */
@RestController
public class DataController {

    @Autowired
    private PersonRepository personRepository;

    /**
     * 保存操作,支持批量保存.
     *
     * @param name
     * @param address
     * @param age
     * @return
     */
    @RequestMapping("/save")
    public Person save(String name, String address, Integer age) {
        Person person = personRepository.save(new Person(name, age, address));
        return person;
    }

    /**
     * 测试findByAddress.
     *
     * @param address
     * @return
     */
    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    /**
     * 测试findByNameAndAddress
     *
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q2")
    public Person q2(String name, String address) {
        Person person = personRepository.findByNameAndAddress(name, address);
        return person;
    }

    /**
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q3")
    public Person p3(String name, String address) {
        Person person = personRepository.withNameAndAddressQuery(name, address);
        return person;
    }

    /**
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/q4")
    public Person q4(String name, String address) {
        Person person = personRepository.withNameAndAddressNamedQuery(name, address);
        return person;
    }

    /**
     * 测试排序
     *
     * @return
     */
    @RequestMapping("/sort")
    public List<Person> sort() {
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return people;
    }

    @RequestMapping("/page")
    public Page<Person> page() {
        Page<Person> pagePeople = personRepository.findAll(new PageRequest(0, 3));
        return pagePeople;
    }

    @RequestMapping("/auto")
    public Page<Person> auto(Person person) {
        Page<Person> personPage = personRepository.findByAuto(person, new PageRequest(0, 10));
        return personPage;
    }
}

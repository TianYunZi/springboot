package org.mybatis.chapter01.model;

import org.mybatis.chapter01.enums.PersonType;

/**
 * Created by Admin on 2017/12/7.
 */
public class Person {

    private String id;
    private String name;
    //枚举
    private PersonType personType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", personType=" + personType +
                '}';
    }
}

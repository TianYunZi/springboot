package org.mybatis.chapter01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.chapter01.model.Person;

import java.util.List;

/**
 * Created by Admin on 2017/12/7.
 */
@Mapper
public interface PersonMapper {
    List<Person> query();

    List<Person> select(@Param("type") String personType);
}

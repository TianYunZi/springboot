package com.boot.dao;

import com.boot.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 2017/7/7.
 */
@Mapper
public interface PersonMapper {

    Person select(@Param("id") int id);

    void update(Person person);
}

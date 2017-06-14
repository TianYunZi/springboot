package com.boot.dao;

import com.boot.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Admin on 2017/6/14.
 */
public interface PersonRepository extends MongoRepository<Person, String> {

    //方法名查询
    Person findByName(String name);

    //支持@Query查询，查询参数构造JSON字符串即可
    @Query("{'age': ?0}")
    List<Person> withQueryFindByAge(Integer age);
}

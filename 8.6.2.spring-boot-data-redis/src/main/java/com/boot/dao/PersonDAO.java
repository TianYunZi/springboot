package com.boot.dao;

import com.boot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 2017/6/14.
 */
@Repository
public class PersonDAO {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, String> valueOperationsStr;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object, Object> valueOperations;

    public void stringRedisTemplateDemo() {
        valueOperationsStr.set("xx", "yy", 1L, TimeUnit.DAYS);
    }

    public void save(Person person) {
        valueOperations.set(person.getId(), person, 1L, TimeUnit.DAYS);
    }

    public String getString() {
        return valueOperationsStr.get("xx");
    }

    public Person getPerson() {
        return (Person) valueOperations.get("1");
    }
}

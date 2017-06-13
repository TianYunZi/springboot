package com.boot.dao;

import com.boot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by XJX on 2017/6/13.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}

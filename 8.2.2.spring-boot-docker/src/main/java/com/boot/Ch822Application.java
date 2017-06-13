package com.boot;

import com.boot.dao.CustomRepositoryFactoryBean;
import com.boot.dao.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Admin on 2017/6/13.
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class Ch822Application {

    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ch822Application.class, args);
    }
}

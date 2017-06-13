package com.boot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by Admin on 2017/6/13.
 * 定义实现{@link CustomRepository}
 */
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements
        CustomRepository<T, ID> {

    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(CustomerSpecs.byAuto(entityManager, example), pageable);
    }
}

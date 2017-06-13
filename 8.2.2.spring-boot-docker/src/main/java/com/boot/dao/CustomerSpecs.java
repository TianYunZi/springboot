package com.boot.dao;

import com.google.common.collect.Iterables;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2017/6/13.
 * 定义Specification：对于任意实体对象进行查询，对象里有几个值我们就查几个值，当值为字符型时我们就自动like查询，其余的
 * 类型使用自动等于查询，没有值我们就查询全部
 */
public class CustomerSpecs {

    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) {
        final Class<T> type = (Class<T>) example.getClass();

        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                EntityType<T> entity = entityManager.getMetamodel().entity(type);

                for (Attribute<T, ?> attribute : entity.getDeclaredAttributes()) {
                    Object attrValue = getValue(example, attribute);
                    if (attrValue != null) {
                        if (attribute.getJavaType() == String.class) {
                            if (!StringUtils.isEmpty(attrValue)) {
                                predicates.add(cb.like(root.get(attribute(entity, attribute.getName(), String.class)),
                                        pattern((String) attrValue)));
                            }
                        } else {
                            predicates.add(cb.equal(root.get(attribute(entity, attribute.getName(), attrValue.getClass
                                    ())), attrValue));
                        }
                    }
                }
                return predicates.isEmpty() ? cb.conjunction() : cb.and(Iterables.toArray(predicates, Predicate.class));
            }
        };
    }

    private static <T> Object getValue(T example, Attribute<T, ?> attribute) {
        return ReflectionUtils.getField((Field) attribute.getJavaMember(), example);
    }

    private static <E, T> SingularAttribute<T, E> attribute(EntityType<T> entityType, String fieldName, Class<E>
            fieldClass) {
        return entityType.getDeclaredSingularAttribute(fieldName, fieldClass);
    }

    private static String pattern(String string) {
        return "%" + string + "%";
    }
}

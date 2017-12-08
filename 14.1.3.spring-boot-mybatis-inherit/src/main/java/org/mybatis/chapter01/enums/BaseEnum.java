package org.mybatis.chapter01.enums;

/**
 * Created by Admin on 2017/12/8.
 */
public interface BaseEnum<E extends Enum<?>, T> {
    T getValue();

    String getDisplayName();
}

package org.mybatis.chapter01.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 2017/12/8.
 */
public enum PersonType implements BaseEnum<PersonType, String> {
    student("1", "学生"),
    teacher("2", "教师");

    private String value;
    private String displayName;

    static Map<String, PersonType> enumMap = new HashMap<>();

    static {
        for (PersonType type : PersonType.values()) {
            enumMap.put(type.getValue(), type);
        }
    }

    private PersonType(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public static PersonType getEnum(String value) {
        return enumMap.get(value);
    }
}

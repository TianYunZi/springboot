package org.mybatis.chapter01.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 2017/12/8.
 */
public enum OrgType implements BaseEnum<OrgType, String> {
    ORG("1", "机构"),
    PERSON("2", "个人");

    private String value;
    private String displayName;

    static Map<String, OrgType> enumMap = new HashMap<>();

    static {
        for (OrgType type : OrgType.values()) {
            enumMap.put(type.getValue(), type);
        }
    }

    OrgType(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public String getDisplayName() {
        return null;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public static OrgType getEnum(String value) {
        return enumMap.get(value);
    }
}

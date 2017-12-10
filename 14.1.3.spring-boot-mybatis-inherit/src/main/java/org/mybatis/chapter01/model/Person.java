package org.mybatis.chapter01.model;

import org.mybatis.chapter01.enums.OrgType;

/**
 * Created by Admin on 2017/12/8.
 */
public class Person extends OrganizationBase {

    /**
     * 员工的手机号码
     */
    private String mobile;
    /**
     * 员工的邮箱地址
     */
    private String email;

    protected Person() {
        super(OrgType.PERSON);
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

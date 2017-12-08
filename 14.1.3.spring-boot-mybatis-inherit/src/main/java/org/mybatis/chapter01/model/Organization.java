package org.mybatis.chapter01.model;

import org.mybatis.chapter01.enums.OrgType;

/**
 * Created by Admin on 2017/12/8.
 */
public class Organization extends OrganizationBase {
    protected Organization() {
        super(OrgType.ORG);
    }
}

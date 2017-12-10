package org.mybatis.chapter01.model;

import org.mybatis.chapter01.enums.OrgType;

/**
 * Created by Admin on 2017/12/8.
 */
public abstract class OrganizationBase {

    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型，1：机构，2：部门，3：岗位，4：个人
     */
    private OrgType type;
    /**
     * 父级组织的ID
     */
    private Integer parentId;

    protected OrganizationBase(OrgType type) {
        this.type = type;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public OrgType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(OrgType type) {
        this.type = type;
    }

    /**
     * @return the parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}

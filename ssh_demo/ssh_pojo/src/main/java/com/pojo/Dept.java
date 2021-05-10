package com.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Dept implements Serializable {

    @Id
    private String id;

    private String deptName;

    @JSONField(serialize = false)
    private Dept parent;
    @Column(name = "state")
    private Integer state;

    private String companyId;

    private String companyName;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Dept getParent() {
        return parent;
    }

    public void setParent(Dept parent) {
        this.parent = parent;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", deptName='" + deptName + '\'' +
                ", state=" + state +
                '}';
    }
}


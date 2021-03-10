package com.struts.action;

import com.struts.action.pojo.Person;

public class UserAction {
    private Integer id;
    private String name;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public   String  execute() {
        return  "success";
    }

}

package com.ognl.action;


public class ognlAction {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute() {
        this.name = "ÍõÎå";
        return "messagelist";
    }


}

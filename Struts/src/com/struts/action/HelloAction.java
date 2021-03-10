package com.struts.action;

public class HelloAction {

    private   String  msg;

    public String getMsg() {
        return msg;
    }
    public String  addUi(){
        this.msg="add";
        return "success";
    }

    public String execute(){
        this.msg="execute";
        return "success";
    }
}


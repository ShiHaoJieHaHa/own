package com.struts.message;



public class MessageAction {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String addUi() {
        return "success";
    }

    public String execute() {
        this.message = "execute";
        return "success";
    }

}

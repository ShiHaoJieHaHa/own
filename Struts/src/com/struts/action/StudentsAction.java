package com.struts.action;

import java.util.Date;

public class StudentsAction {
    private Date day;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }
    public String  execute(){
        return "success";
    }
}

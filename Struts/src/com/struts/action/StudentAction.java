package com.struts.action;

import java.util.Date;

public class StudentAction {
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        System.out.println(birthday);
        this.birthday = birthday;
    }

    public String execute() throws Exception {
        return "success";
    }


}

package com.internationalization;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class actionholdAction  extends ActionSupport {
    @Override
    public String execute() throws Exception {
        ActionContext.getContext().put("message",this.getText("Some",
                new String[]{"lili","study"}));
        return "message";
    }
}

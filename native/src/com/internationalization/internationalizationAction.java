package com.internationalization;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class internationalizationAction  extends ActionSupport {

    @Override
    public String execute() throws Exception {
        ActionContext.getContext().put("message",this.getText("welcome"));
        return "message";
    }
}

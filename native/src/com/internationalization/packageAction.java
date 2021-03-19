package com.internationalization;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class packageAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        ActionContext.getContext().put("message",this.getText("Cone",
                new String[]{"lining","study"}));
        return "message";
    }
}

package com.internationalization;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class placeholderAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        ActionContext.getContext().put("message",this.getText("Come",
                new String[]{"lining","study"}));
        return "message";
    }
}

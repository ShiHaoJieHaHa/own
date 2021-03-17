package com.struts.other;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//对指定的action方法的xml配置  ActionName-方法Name-validation.xml
public class PersoncheckOwnAction extends ActionSupport {

    private String username;
    private String mobile;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String update(){
        ActionContext.getContext().put("message", "更新成功");
        return "message";
    }

    public String save(){
        ActionContext.getContext().put("message", "保存成功");
        return "message";
    }

}

package com.struts.personal;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


import java.util.regex.Pattern;

public class PersonalOtherAction extends ActionSupport {
    private String username;
    /*private String  brithday;*/
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

  /*  public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }*/

    public String update(){
        ActionContext.getContext().put("message", "更新成功");
        return "message";
    }

    public String save(){
        ActionContext.getContext().put("message", "保存成功");
        return "message";
    }
    //提供会对update()方法校验
    public void validateUpdate() {
        if(this.username==null || "".equals(this.username.trim())){
            this.addFieldError("username", "用户名不能为空");
        }
        /*if(this.brithday==null || "".equals(this.brithday.trim())){
            this.addFieldError("brithday", "生日不能为空");
        }*/
        if(this.mobile==null || "".equals(this.mobile.trim())){
            this.addFieldError("mobile", "手机号不能为空");
        }else{
            if(!Pattern.compile("^1[358]\\d{9}$").matcher(this.mobile).matches()){
                this.addFieldError("mobile", "手机号格式不正确");
            }
        }
    }

}

package com.struts.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HelloWorldAction {
    private String msg;
    private  String username;
    private String   savePath;

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getMsg() {
        return msg;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String execute() throws UnsupportedEncodingException {
        this.username= URLEncoder.encode("张三", "UTF-8") ;
       /* this.username="张三";*/
        msg = "我的第一个程序";
        return "success";
    }
    public  String add(){
        msg = "我的";
        return "message";
    }

}

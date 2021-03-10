package com.struts.result;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class ReslutApplication {


    public String execute() {
        ActionContext actionContext = ActionContext.getContext();
        actionContext.getApplication().put("app", "应用范围");
        actionContext.getSession().put("session", "session的应用范围");
        actionContext.put("request", "request范围");
        actionContext.put("names", Arrays.asList("老陈","老李","老张"));
        return "success";
    }

    public String rsa()  {
        HttpServletRequest request = ServletActionContext.getRequest();
        ServletContext context = ServletActionContext.getServletContext();
        request.setAttribute("request","请求request数据");
        request.getSession().setAttribute("session","请求session数据");
        context.setAttribute("app","Context数据内容");
        return "success";
    }


}

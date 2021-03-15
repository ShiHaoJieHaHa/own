package com.struts.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PermissionInterceptor  implements Interceptor {

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Object user = ActionContext.getContext().getSession().get("user");
        if (user!=null){
            actionInvocation.invoke();
        }
         ActionContext.getContext().put("message","你没有权限执行该操作");
        return "success";
    }
}

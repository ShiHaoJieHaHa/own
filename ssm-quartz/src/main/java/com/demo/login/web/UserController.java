package com.demo.login.web;


import com.demo.login.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
     public String user(){
        return  "/user/user";
    }

    @RequiresRoles("admin")
    @RequestMapping("/admin")
    public String admin(){
         return "/user/admin";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "/login/login";
    }
}

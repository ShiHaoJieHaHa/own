package com.demo.user.controller;


import com.demo.user.pojo.User;
import com.demo.user.service.UserService;
import com.demo.util.PageQueryBean;
import com.demo.util.QueryCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("addUser")
    public void addUser(){
        userService.addUser();
    }

    @RequestMapping("/users")
    public String showUsers(Model model){
        return "/user/users";
    }

    @RequestMapping("/userList")
    @ResponseBody
    public PageQueryBean listUsers(QueryCondition queryCondition){
        PageQueryBean result = userService.selectAllByPage(queryCondition);
        return result;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(int id){
        User user = userService.getUserById(id);
        return user;
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(id);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        user.setName(name);
        user.setAge(age);
        userService.updateUser(user);
        return "succ";
    }



}

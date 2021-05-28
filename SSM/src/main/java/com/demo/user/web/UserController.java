package com.demo.user.web;

import com.demo.user.entity.User;
import com.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("addUser")
    public void addUser(){
        userService.addUser();
    }

    @RequestMapping("/users")
    public String showUsers(Model model){
        List<User> users = userService.showUsers();
        model.addAttribute("users",users);
        return "/users";
    }

    @RequestMapping("/getUser/{id}")
    @ResponseBody
    public User getUser(@PathVariable int id){
        User user = userService.getUserById(id);
        return user;
    }
}

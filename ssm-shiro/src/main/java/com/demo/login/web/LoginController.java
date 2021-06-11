package com.demo.login.web;

import com.demo.login.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("")
    public String login(){
        return "login/login";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(@RequestParam String username, @RequestParam String password, Model model,HttpSession session){
       /* User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        model.addAttribute("loginUser",user);
        return "/user/user";*/
        System.out.println("username="+username+",password="+password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        try {
            subject.login(token);
            User loginUser = (User)session.getAttribute("loginUser");
            model.addAttribute("loginUser",loginUser);
            return  "/login/index";
        }catch (Exception e){
            return "/login/login";
        }
    }
}

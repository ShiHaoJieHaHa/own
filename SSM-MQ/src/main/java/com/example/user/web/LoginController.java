package com.example.user.web;


import com.example.common.constants.Constants;
import com.example.common.resp.Result;
import com.example.register.entity.Register;
import com.example.register.service.RegisterService;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private RegisterService registerService;

    @RequestMapping("")
    public String login(){

        return "login/login";
    }

    @RequestMapping("/loginSucc")
    public String loginSucc(){
        return "/login/loginSucc";
    }

    @RequestMapping("/check")
    @ResponseBody
    public Result check(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Result result = new Result();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            if(userService.getUserByEmail(email)!=null){
                Long userId = userService.getUserByEmail(email).getId();
                Register register = registerService.getRegisterByUserId(userId);
                if(register.getState()==1){
                    result.setCode(Constants.RESP_STATUS_OK);
                    return result;
                }else {
                    result.setCode(Constants.RESP_STATUS_BADREQUEST);
                    return result;
                }
            }else {
                result.setCode(Constants.RESP_STATUS_BADREQUEST);
                return result;
            }
        } catch (Exception e) {
            result.setCode(Constants.RESP_STATUS_BADREQUEST);
            return result;
        }
    }
}

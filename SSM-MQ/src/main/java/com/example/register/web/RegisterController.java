package com.example.register.web;


import com.example.common.constants.Constants;
import com.example.common.exception.MyException;
import com.example.common.resp.Result;
import com.example.register.entity.Register;
import com.example.register.service.RegisterService;
import com.example.user.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


@Controller
@RequestMapping("register")
@Slf4j
public class RegisterController {


    @Autowired
    private RegisterService registerService;
    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String register() {
        return "/register/register";
    }

    @RequestMapping("/regist")
    public String regist(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        try{
            System.out.println("===================regist=========================");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String rePassword = request.getParameter("rePassword");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phoneNumber");
            if(StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(rePassword) || StringUtils.isBlank(email) || StringUtils.isBlank(phoneNumber)){
                return null;
            }
            //将收到的注册信息存到数据库中，并且发送激活邮件，用户未点击激活邮件，状态设为0，表示不可用，点击之后设为1，表示用户可用。
            registerService.addNewUser(username,password,rePassword,email,phoneNumber);
        }catch (Exception e){
            log.error("注册失败",e);
            throw e;
        }
        return "/register/tip";
    }

    @RequestMapping("/checkEmail")
    @ResponseBody
    public Result checkEmail(HttpServletRequest request){
        Result result = new Result();
        String email = request.getParameter("email");
        if(StringUtils.isBlank(email)){
            result.setCode(Constants.RESP_STATUS_INTERNAL_ERROR);
            return result;
        }
//      从数据库查询是否存在这个邮箱
        try{
            if(!registerService.isUserOld(email)){
                //说明这个邮箱已经被注册了
                result.setMessgae("邮箱已经被注册");
                result.setCode(Constants.RESP_STATUS_BADREQUEST);
            }
        } catch (Exception e){
            result.setCode(Constants.RESP_STATUS_INTERNAL_ERROR);
            result.setMessgae("未知错误");
        }
        return result;
    }


    @RequestMapping(value = "/active",method = RequestMethod.GET)
    public String active(@RequestParam String code) throws MyException, MyException {
        try{
            if(StringUtils.isBlank(code)){
                log.error("用户code为空");
                throw new MyException("用户激活邮件的参数有问题");
            }
//        根据code获取该用户信息，将状态置为1即激活
        /*先根据code获取注册信息，拿到用户id*/
            Register r = registerService.getRegisterByCode(code);
            if(r.getState()==0){
                r.setState((byte)1);
                registerService.updateStatus(r);
                return "/register/active";
            }else{
                return "/register/fail";
            }
        }catch (Exception e){
            log.error("激活失败",e);
            throw e;
        }
    }

}
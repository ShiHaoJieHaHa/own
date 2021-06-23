package com.example.register.service;



import com.example.common.exception.MyException;
import com.example.register.entity.Register;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


public interface RegisterService {
    Boolean isUserOld(String email);

    void addNewUser(String username, String password, String rePassword, String email, String phoneNumber) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    Register getRegisterByCode(String code) throws MyException;

    void updateStatus(Register r);

    Register getRegisterByUserId(Long userId);
}

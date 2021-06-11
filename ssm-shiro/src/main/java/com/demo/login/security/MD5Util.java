package com.demo.login.security;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /*MD5加密方法*/
    public static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //防止加密字符串乱码情况
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String result = base64Encoder.encode(md5.digest(password.getBytes("utf-8")));
        return result;
    }

    /*判断密码是否相等*/
    public  static boolean  checkPassword(String inputPwd,String dbPwd) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String result = encryptPassword(inputPwd);
        if(result.equals(dbPwd)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception{
        String result = MD5Util.encryptPassword("123");
        System.out.println("result:"+result);
    }
}

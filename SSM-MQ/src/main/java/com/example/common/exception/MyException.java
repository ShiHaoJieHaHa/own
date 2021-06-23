package com.example.common.exception;


import com.example.common.constants.Constants;

public class MyException extends Exception{
    public MyException(String message){
        super(message);
    }

    public int getStatusCode(){
        return Constants.RESP_STATUS_INTERNAL_ERROR;
    }
}

package com.example.common.resp;


import com.example.common.constants.Constants;
import lombok.Data;


@Data
public class Result <T>{
    private int code = Constants.RESP_STATUS_OK;
    private String messgae;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", messgae='" + messgae + '\'' +
                ", data=" + data +
                '}';
    }
}

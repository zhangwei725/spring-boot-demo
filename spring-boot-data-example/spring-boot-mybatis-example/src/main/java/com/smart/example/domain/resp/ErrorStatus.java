package com.smart.example.domain.resp;

import lombok.Data;


public enum ErrorStatus {
    //   错误的 信息
    USER_PASSWORD_ERROR(40004, "username and password no exist"),
    ACCOUNT_LOCKED_ERROR(40005, "account  locked ");
    private String msg;
    private int status;

    ErrorStatus(int status, String msg) {
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

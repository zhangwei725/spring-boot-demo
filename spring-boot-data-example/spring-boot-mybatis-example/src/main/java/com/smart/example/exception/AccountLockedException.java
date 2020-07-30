package com.smart.example.exception;

import com.smart.example.domain.resp.ErrorStatus;

public class AccountLockedException extends RuntimeException {
    private String msg;
    private int status;

    public AccountLockedException(ErrorStatus errorStatus) {
        this.status = errorStatus.getStatus();
        this.msg = errorStatus.getMsg();
    }
}

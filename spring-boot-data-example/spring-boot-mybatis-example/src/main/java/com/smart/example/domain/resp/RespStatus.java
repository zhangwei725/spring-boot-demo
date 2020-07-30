package com.smart.example.domain.resp;

import lombok.Data;

@Data
public class RespStatus<T> {
    private int status;
    private String msg;
    private T data;

    public static <T> RespStatus<T> success(T data) {
        RespStatus responseStatus = new RespStatus();
        responseStatus.setData(data);
        responseStatus.setStatus(200);
        responseStatus.setMsg("success");
        return responseStatus;
    }

}

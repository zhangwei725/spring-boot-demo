package com.smart.rest.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespEntity<T> extends BaseEntity {
    private String msg;
    private int status;
    private T data;

    public static <T> RespEntity<T> success(T data) {
        return (RespEntity<T>) RespEntity.builder()
                .data(data)
                .msg(RespConstant.RespConstantsMsg.MSG_SUCCESS)
                .status(RespConstant.RespConstantsCode.CODE_SUCCESS)
                .build();
    }

    public static <T> RespEntity<T> error(T data) {
        return (RespEntity<T>) RespEntity.builder()
                .msg(RespConstant.RespConstantsMsg.MSG_SUCCESS)
                .status(RespConstant.RespConstantsCode.CODE_SUCCESS)
                .build();
    }

}

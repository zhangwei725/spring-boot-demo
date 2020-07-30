package com.smart.example.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserVo {
    /**
     * 用户Id
     */
    private Integer uid;
    /**
     * 用户名
     */
    private String username;
    /**
     * 手机
     */
    private String phone;

    /**
     * 性别 1 表示男 0 表示女
     */
    private Boolean sex;

    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像图片路径
     */
    private String head;

    /**
     * 注册时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HHmmss")
    private Date regTime;

}

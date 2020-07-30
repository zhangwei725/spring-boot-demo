package com.smart.example.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class User {
    /**
    * 用户Id
    */
    private Integer uid;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

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
    * 备注
    */
    private String mark;

    /**
    * 最后一次登录时间
    */
    private Date lastLogin;

    /**
    * 登录ip
    */
    private String loginIp;

    /**
    * 头像图片路径
    */
    private String head;

    /**
    * 注册时间
    */
    private Date regTime;

    /**
    * 账号是否被锁定 1 表示未锁定 0 表示锁定
    */
    private Boolean locked;
}
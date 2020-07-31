package com.smart.sw.controller;

import com.smart.sw.domain.request.UserRequestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@Api("用户中心")
@RestController
public class UserController {
    @ApiOperation("用户登录")
    @PostMapping("login")
    public String login(@ApiParam("账号") String username,
                        @ApiParam("密码") String password) {
        return "登录功能";
    }

    @ApiOperation(value = "用户注册",notes = "")
    @PostMapping("/register")
    public String register(UserRequestParam param) {
        return "";
    }

}

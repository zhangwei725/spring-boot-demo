package com.smart.example.controller;

import com.smart.example.domain.entity.User;
import com.smart.example.domain.resp.RespStatus;
import com.smart.example.domain.vo.UserVo;
import com.smart.example.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class LoginController {
    @Resource
    UserService userService;

    public RespStatus<UserVo> login(@Pattern(regexp = "[a-zA-Z]\\w{7,16}", message = "用户名格式不对")
                                    @RequestParam() String username,
                                    @Pattern(regexp = "[a-zA-Z]\\w{7,16}", message = "密码格式不对")
                                            String password) {
        UserVo userVo = userService.login(username, password);
        return RespStatus.success(userVo);

    }


}

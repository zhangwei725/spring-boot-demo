package com.smart.example.service;

import com.smart.example.domain.entity.User;
import com.smart.example.domain.vo.UserVo;


public interface UserService {
    UserVo login(String username, String password);
}

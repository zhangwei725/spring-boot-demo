package com.smart.example.service.impl;

import com.smart.example.domain.entity.User;
import com.smart.example.domain.resp.ErrorStatus;
import com.smart.example.domain.vo.UserVo;
import com.smart.example.exception.AccountLockedException;
import com.smart.example.exception.UserAndPasswordException;
import com.smart.example.mapper.UserMapper;
import com.smart.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public UserVo login(String username, String password) {
        UserVo userVo = null;
        User user = userMapper.selectUserByName(username);
        if (user != null) {
            if (!user.getLocked()) {
                if (user.getPassword().equals(password)) {
                    BeanUtils.copyProperties(user, userVo);
                } else {
                    throw new UserAndPasswordException(ErrorStatus.USER_PASSWORD_ERROR);
                }
            } else {
                throw new AccountLockedException(ErrorStatus.ACCOUNT_LOCKED_ERROR);
            }
        } else {
            throw new UserAndPasswordException(ErrorStatus.USER_PASSWORD_ERROR);
        }
        return userVo;
    }
}

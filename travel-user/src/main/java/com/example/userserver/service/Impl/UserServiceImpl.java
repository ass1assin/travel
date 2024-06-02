package com.example.userserver.service.Impl;


import com.example.model.User;
import com.example.userserver.mapper.UserMapper;
import com.example.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findInfo(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return null;
        }else {
            User user = userMapper.findInfo(username, password);
            return user;
        }
    }
    @Override
    public User register(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return null;
        }else {
            User user = userMapper.register(username, password);
            return user;
        }
    }

}

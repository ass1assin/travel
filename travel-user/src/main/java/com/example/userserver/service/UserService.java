package com.example.userserver.service;


import com.example.model.User;

public interface UserService {
    User findInfo(String username, String password);

    User register(String username, String password);
}

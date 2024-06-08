package com.example.userserver;

import com.example.userserver.mapper.UserMapper;
import com.example.userserver.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServerApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        userService.findInfo("lk","123456");
    }

//    @Test
//    void contextLoads2() {
//        userMapper.findInfo("lk","123456");
//    }

}

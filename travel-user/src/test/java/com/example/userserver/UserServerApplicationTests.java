package com.example.userserver;

import com.example.userserver.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServerApplicationTests {

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        userService.findInfo("lk","123456");
    }

}

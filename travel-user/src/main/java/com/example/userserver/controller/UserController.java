package com.example.userserver.controller;

import com.example.model.User;
import com.example.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/getLogin")
    public User login(@RequestParam String username, @RequestParam String password) {
        return userService.findInfo(username, password);
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        User user = userService.findInfo(username, password);
        if (user != null) {
            return "already_registered";
        }
        userService.register(username, password);
        return "registration_success";
    }
}

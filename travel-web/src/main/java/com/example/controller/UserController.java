package com.example.controller;

import com.example.client.UserDataClient;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserDataClient userClient;

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/html/login");
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, @RequestParam String type, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        switch (type) {
            case "login":
                User user = userClient.login(username, password);
                if (user == null) {
                    // 用户名或密码错误返回登录界面
                    modelAndView.addObject("error", "用户名或密码输入错误");
                    modelAndView.setViewName("/html/login");
                } else {
                    modelAndView.setViewName("redirect:/spots");
                }
                break;
            case "register":
                String result = userClient.register(username, password);
                if ("already_registered".equals(result)) {
                    // 用户名或密码错误返回登录界面
                    modelAndView.addObject("error", "已经注册过了");
                    modelAndView.setViewName("/html/login");
                } else if ("registration_success".equals(result)) {
                    modelAndView.setViewName("/html/index");
                    // 登录成功
                }
                break;
        }
        session.setAttribute("userLoggedIn", true);
        return modelAndView;
    }
}

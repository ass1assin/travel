package com.example.controller;

import com.example.client.UserDataClient;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserDataClient userClient;

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, @RequestParam String type, HttpSession session,HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        switch (type) {
            case "login":
                User user = userClient.login(username, password);
                if (user == null) {
                    // 用户名或密码错误返回登录界面
                    modelAndView.addObject("error", "用户名或密码输入错误");
                    modelAndView.setViewName("/login");
                } else {
                    addUserInfoToCookie(user, response);
                    session.setAttribute("userLoggedIn", true);
                    session.setAttribute("username", user.getUserName());
                    session.setAttribute("userAvatar", user.getUserAvatar());
                    modelAndView.setViewName("redirect:http://localhost:10010/dev-html/spots");
                }
                break;
            case "register":
                String result = userClient.register(username, password);
                if ("already_registered".equals(result)) {
                    modelAndView.addObject("error", "已经注册过了");
                    modelAndView.setViewName("/login");
                } else if ("registration_success".equals(result)) {
                    modelAndView.addObject("error", "注册成功");
                    modelAndView.setViewName("/login");
                }
                break;
        }
        return modelAndView;
    }

    private void addUserInfoToCookie(User user, HttpServletResponse response) {
        // 将用户的个人信息存储到cookie中
        Cookie usernameCookie = new Cookie("username", user.getUserName());
        Cookie passwordCookie = new Cookie("password", user.getPassWord());
        Cookie userAvatarCookie = new Cookie("userAvatar", user.getUserAvatar());

        // 设置cookie的有效路径和有效期
        usernameCookie.setPath("/");
        passwordCookie.setPath("/");
        userAvatarCookie.setPath("/");
        usernameCookie.setMaxAge(60 * 60 * 24); // 1天
        passwordCookie.setMaxAge(60 * 60 * 24); // 1天
        userAvatarCookie.setMaxAge(60 * 60 * 24); // 1天

        // 添加cookie到响应
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
        response.addCookie(userAvatarCookie);
    }
@GetMapping("/personInfo")
public ModelAndView getPersonInfo(HttpServletRequest request) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("/personinfo");

    // 获取存储在cookie中的用户信息
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                modelAndView.addObject("username", cookie.getValue());
            } else if ("password".equals(cookie.getName())) {
                modelAndView.addObject("password", cookie.getValue());
            }
        }
    }

    return modelAndView;
}

//    @GetMapping("/info")
//    public ModelAndView info(HttpServletRequest request) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("/header");
//        // 获取存储在cookie中的用户信息
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("username".equals(cookie.getName())) {
//                    modelAndView.addObject("username", cookie.getValue());
//                }
//            }
//        }
//        return modelAndView;
//    }
}

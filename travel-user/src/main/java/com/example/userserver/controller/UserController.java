package com.example.userserver.controller;

import com.example.model.User;
import com.example.userserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, @RequestParam String type, HttpSession session){
        ModelAndView modelAndView =new ModelAndView();
        switch (type) {
            case "login":
                User user = userService.findInfo(username, password);

                if (user == null){
                    //         用户名或密码错误返回登录界面
                    modelAndView.addObject("error","用户名或密码输入错误");
                    modelAndView.setViewName("/html/login");
                }
                else {
                    modelAndView.setViewName("/html/index");
                }
                break;
            case "register":
                User user1 = userService.findInfo(username, password);

                if (user1 != null){
                    //         用户名或密码错误返回登录界面
                    modelAndView.addObject("error","已经注册");
                    modelAndView.setViewName("/html/login");
                }
                else {
                    userService.register(username, password);
                    System.out.println("成功注册");
                    modelAndView.setViewName("/html/index");
//                    modelAndView.setViewName("/common/index");
                    //         登录成功
                }
                break;
        }

//        modelAndView.setViewName("/html/login");

        return modelAndView;
    }
}

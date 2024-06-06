package com.example.client;

import com.example.model.Notice;
import com.example.model.User;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "travel-user", contextId="userDataClient")
public interface UserDataClient {
    @PostMapping("/getLogin")
    User login(@RequestParam("username") String username, @RequestParam("password") String password);

    @PostMapping("/register")
    String register(@RequestParam("username") String username, @RequestParam("password") String password);

}

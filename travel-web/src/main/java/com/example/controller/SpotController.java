package com.example.controller;

import com.example.model.Notice;
import com.example.model.Spot;
import com.github.pagehelper.PageInfo;
import com.example.client.SpotDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpotController {

    @Autowired
    private SpotDataClient spotDataClient;

    @GetMapping("/spots")
    public ModelAndView getSpot(@RequestParam(defaultValue = "1") int currentPage, // 默认为第一页
                                @RequestParam(defaultValue = "10") int pageSize    // 默认为每页10条
    ) {
        ModelAndView modelAndView = new ModelAndView("index");
        PageInfo<Notice> pageInfo = spotDataClient.getSpots(currentPage, pageSize);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }
}

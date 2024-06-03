package com.example.controller;

import com.example.model.Notice;
import com.github.pagehelper.PageInfo;
import com.example.client.TrafficDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrafficController {
    @Autowired
    private TrafficDataClient trafficDataClient;

    @GetMapping("/trafficSpots")
    public ModelAndView getTrafficSpot(@RequestParam(defaultValue = "1") int currentPage,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        ModelAndView modelAndView = new ModelAndView("traffic");
        PageInfo<Notice> pageInfo = trafficDataClient.getTrafficSpots(currentPage, pageSize);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }
}

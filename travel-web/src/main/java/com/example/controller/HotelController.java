package com.example.controller;

import com.example.model.Hotel;
import com.github.pagehelper.PageInfo;
import com.example.client.HotelDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelController {
    @Autowired
    private HotelDataClient hotelDataClient;


    @GetMapping("/hotel")
    public ModelAndView getSpot(@RequestParam(defaultValue = "1") int currentPage, // 默认为第一页
                                @RequestParam(defaultValue = "10") int pageSize    // 默认为每页10条
    ) {
        ModelAndView modelAndView = new ModelAndView("listing");
        PageInfo<Hotel> pageInfo = hotelDataClient.getHotel(currentPage, pageSize);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

//    @Autowired
//    private TrafficDataClient trafficDataClient;
//
//    @GetMapping("/trafficSpots")
//    public ModelAndView getTrafficSpot(@RequestParam(defaultValue = "1") int currentPage,
//                                       @RequestParam(defaultValue = "10") int pageSize) {
//        ModelAndView modelAndView = new ModelAndView("html/traffic");
//        PageInfo<Notice> pageInfo = trafficDataClient.getTrafficSpots(currentPage, pageSize);
//        modelAndView.addObject("pageInfo", pageInfo);
//        return modelAndView;
//    }
}

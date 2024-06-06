package com.example.controller;

import com.example.client.HotelDetailDataClient;
import com.example.model.Hotel;
import com.example.model.Review;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HotelDetailController {
    @Autowired
    private HotelDetailDataClient hotelDetailDataClient;
    @GetMapping("/hotelDetail")
    public ModelAndView  getHotelDetails(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("hotel_detail");
        Hotel hotel = hotelDetailDataClient.getHotelById(id);
        List<Review> review=hotelDetailDataClient.getReviewById(id);
        modelAndView.addObject("hotelInfo", hotel);
        modelAndView.addObject("reviewInfo", review);
        System.out.println(review);
        return modelAndView;
    }
}

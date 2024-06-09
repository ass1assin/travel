package com.example.dataserver.controller.thymeleaf;

import com.example.dataserver.service.HotelService;
import com.example.model.Review;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @GetMapping("/getHotel")
    public PageInfo<Hotel> getTrafficSpots(@RequestParam(defaultValue = "1") int currentPage,
                                            @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Hotel> hotel = hotelService.getHotel();
        return new PageInfo<>(hotel);
    }

    @GetMapping("/getHotelDetail")
    public Hotel getHotelById(@RequestParam("id") int id) {
        return hotelService.getHotelById(id);
    }

    @GetMapping("/getReviewById")
    public List<Review> getReviewById(@RequestParam("id") int id){
        return hotelService.getReviewById(id);
    }

    @PostMapping("/submitComments")
    public boolean saveComment(@RequestBody Review review){
        return hotelService.saveComment(review);
    }
}

package com.example.dataserver.controller.thymeleaf;

import com.example.dataserver.service.HotelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

//    @GetMapping("/hotel")
//    public ModelAndView getSpot(@RequestParam(defaultValue = "1") int currentPage, // 默认为第一页
//                                @RequestParam(defaultValue = "10") int pageSize    // 默认为每页10条
//    ) {
//        ModelAndView modelAndView = new ModelAndView("html/listing");
//        PageHelper.startPage(currentPage, pageSize);
//        List<Hotel> list = hotelService.getHotel();
//        PageInfo<Hotel> pageInfo = new PageInfo<>(list);
//        modelAndView.addObject("pageInfo", pageInfo);
//        return modelAndView;
//    }
    @GetMapping("/hotel")
    public PageInfo<Hotel> getTrafficSpots(@RequestParam(defaultValue = "1") int currentPage,
                                            @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Hotel> hotel = hotelService.getHotel();
        return new PageInfo<>(hotel);
    }
}

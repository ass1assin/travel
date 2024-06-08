package com.example.controller;

import com.example.model.Hotel;
import com.github.pagehelper.PageInfo;
import com.example.client.HotelDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelDataClient hotelDataClient;
    @GetMapping("/hotel")
    public ModelAndView getHotel(@RequestParam(defaultValue = "1") int currentPage, // 默认为第一页
                                @RequestParam(defaultValue = "10") int pageSize    // 默认为每页10条
    ) {
        ModelAndView modelAndView = new ModelAndView("hotel");
        PageInfo<Hotel> pageInfo = hotelDataClient.getHotel(currentPage, pageSize);

        // 创建两个列表来分别存储奇数和偶数 ID 的 Hotel
        List<Hotel> oddHotels = new ArrayList<>();
        List<Hotel> evenHotels = new ArrayList<>();

        for (Hotel hotel : pageInfo.getList()) {
            if (hotel.getId() % 2 != 0) {
                oddHotels.add(hotel);
            } else {
                evenHotels.add(hotel);
            }
        }
        modelAndView.addObject("oddHotels", oddHotels);
        modelAndView.addObject("evenHotels", evenHotels);
        modelAndView.addObject("pageInfo", pageInfo); // 仍然可以传递原始的 pageInfo 以便其他用途
        return modelAndView;
    }

}

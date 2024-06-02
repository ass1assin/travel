package com.example.dataserver.controller;


import com.example.dataserver.service.HotelManageService;
import com.example.dataserver.service.HotelService;
import com.example.dataserver.service.ScenicSpotService;
import com.example.model.Hotel;
import com.example.model.ScenicSpot;
import com.example.travelframework.utils.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelManageController {
    @Autowired
    public HotelManageService hotelManageService;

    @GetMapping("/getAllHotel")
    public AjaxResult getAllSpot(ScenicSpot scenicSpot){
        PageHelper.startPage(scenicSpot.getCurrentPage(), scenicSpot.getPageSize());
        List<Hotel> list = hotelManageService.getAllHotel();
        PageInfo<Hotel> pageInfo = new PageInfo<>(list);
        return AjaxResult.success(pageInfo);
    }
}

package com.example.dataserver.controller;


import com.example.dataserver.service.ScenicSpotService;
import com.example.model.ScenicSpot;
import com.example.travelframework.utils.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScenicSpotController {
    @Autowired
    public ScenicSpotService scenicSpotService;

    @GetMapping("/getAllSpot")
    public AjaxResult getAllSpot(ScenicSpot scenicSpot){
        PageHelper.startPage(scenicSpot.getCurrentPage(), scenicSpot.getPageSize());
        List<ScenicSpot> list = scenicSpotService.getAllSpot();
        PageInfo<ScenicSpot> pageInfo = new PageInfo<>(list);
        return AjaxResult.success(pageInfo);
    }
    @GetMapping("/test")
    public List<ScenicSpot> test(){
//        PageHelper.startPage(scenicSpot.getCurrentPage(), scenicSpot.getPageSize());
        List<ScenicSpot> list = scenicSpotService.getAllSpot();
//        PageInfo<ScenicSpot> pageInfo = new PageInfo<>(list);
        return list;
    }
}

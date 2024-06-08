package com.example.dataserver.controller;


import com.example.dataserver.service.ScenicSpotService;
import com.example.model.Notice;
import com.example.model.ScenicSpot;
import com.example.travelframework.utils.AjaxResult;
import com.example.travelframework.utils.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScenicSpotController extends BaseController {
    @Autowired
    public ScenicSpotService scenicSpotService;

    @GetMapping("/getAllSpot")
    public AjaxResult getAllSpot(ScenicSpot scenicSpot){
        PageHelper.startPage(scenicSpot.getCurrentPage(), scenicSpot.getPageSize());
        List<ScenicSpot> list = scenicSpotService.getAllSpot(scenicSpot);
        PageInfo<ScenicSpot> pageInfo = new PageInfo<>(list);
        return AjaxResult.success(pageInfo);
    }

    @PostMapping("/addSpot")
    public AjaxResult addSpot(@RequestBody ScenicSpot scenicSpot){
        return toAjax(scenicSpotService.addSpot(scenicSpot));
    }

    @PutMapping("/updateSpot")
    public AjaxResult updateSpot(@RequestBody ScenicSpot scenicSpot){
        return toAjax(scenicSpotService.updateSpot(scenicSpot));
    }
}

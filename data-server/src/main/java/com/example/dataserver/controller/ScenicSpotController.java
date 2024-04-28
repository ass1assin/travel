package com.example.dataserver.controller;

import com.example.dataserver.entity.ScenicSpot;
import com.example.dataserver.service.ScenicSpotService;
import com.example.travelframework.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScenicSpotController {
    @Autowired
    public ScenicSpotService scenicSpotService;

    public AjaxResult getAllSpot(){
        List<ScenicSpot> list = scenicSpotService.getAllSpot();
//        用于封装查询结果以及分页信息，例如总记录数、总页数、当前页码等。
        return AjaxResult.success(list);
    }
}

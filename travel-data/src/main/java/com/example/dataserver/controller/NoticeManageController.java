package com.example.dataserver.controller;

import com.example.dataserver.service.HotelService;
import com.example.dataserver.service.NoticeManageService;
import com.example.model.Notice;
import com.example.model.ScenicSpot;
import com.example.travelframework.utils.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticeManageController {
    @Autowired
    public NoticeManageService noticeManageService;

    @GetMapping("/getAllNotice")
    public AjaxResult getAllSpot(ScenicSpot scenicSpot){
        PageHelper.startPage(scenicSpot.getCurrentPage(), scenicSpot.getPageSize());
        List<Notice> list = noticeManageService.getAllNotice();
        PageInfo<Notice> pageInfo = new PageInfo<>(list);
        return AjaxResult.success(pageInfo);
    }
}

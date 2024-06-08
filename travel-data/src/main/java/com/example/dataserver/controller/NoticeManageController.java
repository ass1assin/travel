package com.example.dataserver.controller;

import com.example.dataserver.service.HotelService;
import com.example.dataserver.service.NoticeManageService;
import com.example.model.Hotel;
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
public class NoticeManageController extends BaseController {
    @Autowired
    public NoticeManageService noticeManageService;

    @GetMapping("/getAllNotice")
    public AjaxResult getAllNotice(Notice notice){
        PageHelper.startPage(notice.getCurrentPage(), notice.getPageSize());
        List<Notice> list = noticeManageService.getAllNotice(notice);
        PageInfo<Notice> pageInfo = new PageInfo<>(list);
        return AjaxResult.success(pageInfo);
    }
    @PostMapping("/addNotice")
    public AjaxResult addHotel(@RequestBody Notice notice){
        return toAjax(noticeManageService.addNotice(notice));
    }

    @PutMapping("/updateNotice")
    public AjaxResult updateHotel(@RequestBody Notice notice){
        return toAjax(noticeManageService.updateNotice(notice));
    }
}

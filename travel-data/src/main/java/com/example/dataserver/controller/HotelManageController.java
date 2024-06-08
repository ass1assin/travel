package com.example.dataserver.controller;


import com.example.dataserver.service.HotelManageService;
import com.example.dataserver.service.HotelService;
import com.example.dataserver.service.ScenicSpotService;
import com.example.model.Hotel;
import com.example.model.ScenicSpot;
import com.example.travelframework.utils.AjaxResult;
import com.example.travelframework.utils.BaseController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class HotelManageController extends BaseController {
    @Autowired
    public HotelManageService hotelManageService;

    @GetMapping("/getAllHotel")
    public AjaxResult getAllHotel(Hotel hotel){
        PageHelper.startPage(hotel.getCurrentPage(), hotel.getPageSize());
        List<Hotel> list = hotelManageService.getAllHotel(hotel);
        PageInfo<Hotel> pageInfo = new PageInfo<>(list);
        return AjaxResult.success(pageInfo);
    }

    @PostMapping("/addHotel")
    public AjaxResult addHotel(@RequestBody Hotel hotel){
        return toAjax(hotelManageService.addHotel(hotel));
    }

    @PutMapping("/updateHotel")
    public AjaxResult updateHotel(@RequestBody Hotel hotel){
        return toAjax(hotelManageService.updateHotel(hotel));
    }
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "请选择要上传的文件";
        }
        try {
            // 获取静态资源目录的绝对路径
            String staticPath = ResourceUtils.getFile("classpath:static").getAbsolutePath();
            // 构建文件保存路径
            String filePath = staticPath + File.separator + "img" + File.separator + file.getOriginalFilename();
            File dest = new File(filePath);
            // 将文件保存到指定路径
            file.transferTo(dest);
            return "图片上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "图片上传失败";
        }
    }
}

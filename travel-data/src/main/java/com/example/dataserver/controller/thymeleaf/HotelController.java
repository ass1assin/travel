package com.example.dataserver.controller.thymeleaf;

import com.example.dataserver.entity.Hotel;
import com.example.dataserver.entity.Notice;
import com.example.dataserver.service.HotelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotel")
    public ModelAndView getSpot(@RequestParam(defaultValue = "1") int currentPage, // 默认为第一页
                                @RequestParam(defaultValue = "10") int pageSize    // 默认为每页10条
    ) {
        ModelAndView modelAndView = new ModelAndView("html/listing");
        PageHelper.startPage(currentPage, pageSize);
        List<Hotel> list = hotelService.getHotel();
        PageInfo<Hotel> pageInfo = new PageInfo<>(list);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }
}

package com.example.dataserver.controller.thymeleaf;
import com.example.dataserver.entity.Notice;
import com.example.dataserver.entity.ScenicSpot;
import com.example.dataserver.entity.Spot;
import com.example.dataserver.service.SpotService;
import com.example.travelframework.utils.AjaxResult;
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

public class SpotController {

    @Autowired
    private SpotService spotService;

    @GetMapping("/spots")
    public ModelAndView getSpot(@RequestParam(defaultValue = "1") int currentPage, // 默认为第一页
                                @RequestParam(defaultValue = "10") int pageSize    // 默认为每页10条
    ) {
        ModelAndView modelAndView = new ModelAndView("html/index");
        PageHelper.startPage(currentPage, pageSize);
        List<Notice> list = spotService.getNotce();
        PageInfo<Notice> pageInfo = new PageInfo<>(list);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }
}

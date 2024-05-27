package com.example.dataserver.controller.thymeleaf;
import com.example.dataserver.entity.ScenicSpot;
import com.example.dataserver.entity.Spot;
import com.example.dataserver.service.SpotService;
import com.example.travelframework.utils.AjaxResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/spot")
public class SpotController {

    @Autowired
    private SpotService spotService;

    @GetMapping("/spot")
    public ModelAndView getSpot(Spot spot) {
        ModelAndView modelAndView = new ModelAndView("html/index");
        PageHelper.startPage(spot.getCurrentPage(), spot.getPageSize());
        List<Spot> list = spotService.getSpot();
        PageInfo<Spot> pageInfo = new PageInfo<>(list);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }
}

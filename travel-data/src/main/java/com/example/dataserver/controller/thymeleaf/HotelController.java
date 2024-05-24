package com.example.dataserver.controller.thymeleaf;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/a")
public class HotelController {

    @GetMapping("/show")
    public ModelAndView getModelAndView() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("hello","test1");
        return modelAndView;
    }
}

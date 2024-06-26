package com.example.dataserver.controller.thymeleaf;

import com.example.dataserver.service.SpotService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.model.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrafficController {
    @Autowired
    private SpotService spotService;

      @GetMapping("/getTrafficSpots")
      public PageInfo<Notice> getTrafficSpots(@RequestParam(defaultValue = "1") int currentPage,
                                              @RequestParam(defaultValue = "10") int pageSize) {
          PageHelper.startPage(currentPage, pageSize);
          List<Notice> notices = spotService.getNotce();
          return new PageInfo<>(notices);
      }
}

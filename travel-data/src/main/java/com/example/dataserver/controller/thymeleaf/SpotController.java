package com.example.dataserver.controller.thymeleaf;
import com.example.dataserver.service.ScenicSpotService;
import com.example.dataserver.service.SpotService;
import com.example.model.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpotController {

    @Autowired
    private SpotService spotService;

      @GetMapping("/getSpots")
      public PageInfo<Notice> getSpots(@RequestParam(defaultValue = "1") int currentPage,
                                              @RequestParam(defaultValue = "10") int pageSize) {
          PageHelper.startPage(currentPage, pageSize);
          List<Notice> notices = spotService.getNotce();
          return new PageInfo<>(notices);
      }
    @GetMapping("/getAllSpots")
    public PageInfo<Spot> getAllSpots(@RequestParam(defaultValue = "1") int currentPage,
                                       @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Spot> scenicSpot = spotService.getAllSpots();
        return new PageInfo<>(scenicSpot);
    }

    @GetMapping("/getSpotDetail")
    public Spot getSpotById(@RequestParam("id") int id) {
        return spotService.getSpotById(id);
    }

    @GetMapping("/getSpotReviewById")
    public List<Review> getSpotReviewById(@RequestParam("id") int id){
        return spotService.getSpotReviewById(id);
    }

    @PostMapping("/submitSpotComments")
    public boolean saveSpotComment(@RequestBody Review review){
        return spotService.saveSpotComment(review);
    }
}

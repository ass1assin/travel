package com.example.client;

import com.example.model.Notice;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "travel-data", contextId="trafficDataClient")
public interface TrafficDataClient {

    @GetMapping("/getTrafficSpots")
    PageInfo<Notice> getTrafficSpots(@RequestParam("currentPage") int currentPage,
                                     @RequestParam("pageSize") int pageSize);
}

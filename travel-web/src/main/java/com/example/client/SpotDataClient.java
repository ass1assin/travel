package com.example.client;

import com.example.model.Notice;
import com.example.model.Spot;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "travel-data", contextId="spotDataClient")
public interface SpotDataClient {
    @GetMapping("/spots")
    PageInfo<Notice> getSpots(@RequestParam("currentPage") int currentPage,
                              @RequestParam("pageSize") int pageSize);
}


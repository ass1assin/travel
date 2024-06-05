package com.example.client;

import com.example.model.Hotel;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "travel-data", contextId="hotelDataClient")
public interface HotelDataClient {
    @GetMapping("/getHotel")
    PageInfo<Hotel> getHotel(@RequestParam("currentPage") int currentPage,
                             @RequestParam("pageSize") int pageSize);
}

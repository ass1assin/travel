package com.example.client;

import com.example.model.Hotel;
import com.example.model.Review;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "travel-data", contextId="hotelDetailDataClient")
public interface HotelDetailDataClient {
    @GetMapping("/getHotelDetail")
    Hotel getHotelById(@RequestParam("id") int id);

    @GetMapping("/getReviewById")
    List<Review> getReviewById(@RequestParam("id") int id);
}

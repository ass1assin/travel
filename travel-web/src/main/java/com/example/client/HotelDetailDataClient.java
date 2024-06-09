package com.example.client;

import com.example.model.Hotel;
import com.example.model.Review;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "travel-data", contextId="hotelDetailDataClient")
public interface HotelDetailDataClient {
    @GetMapping("/getHotelDetail")
    Hotel getHotelById(@RequestParam("id") int id);

    @GetMapping("/getReviewById")
    List<Review> getReviewById(@RequestParam("id") int id);

    @PostMapping("/submitComments")
    ResponseEntity<Boolean> saveComment(@RequestBody Review review);
}

package com.example.client;

import com.example.model.Hotel;
import com.example.model.Review;
import com.example.model.Spot;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "travel-data", contextId="spotDetailDataClient")
public interface SpotDetailDataClient {
    @GetMapping("/getSpotDetail")
    Spot getSpotById(@RequestParam("id") int id);

    @GetMapping("/getSpotReviewById")
    List<Review> getSpotReviewById(@RequestParam("id") int id);

    @PostMapping("/submitSpotComments")
    ResponseEntity<Boolean> saveSpotComment(@RequestBody Review review);
}

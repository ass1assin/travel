package com.example.dataserver.service;

import com.example.model.Hotel;
import com.example.model.Review;

import java.util.List;

public interface HotelService {
    public List<Hotel> getHotel();

    public Hotel getHotelById(int id);

    public List<Review> getReviewById(int id);
    public boolean saveComment(Review review);
}

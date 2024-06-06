package com.example.dataserver.mapper;

import com.example.model.Review;
import org.apache.ibatis.annotations.Mapper;
import com.example.model.Hotel;

import java.util.List;

@Mapper
public interface HotelMapper {
    public List<Hotel> getHotel();

    public Hotel getHotelById(int id);
    public List<Review> getReviewById(int id);
}

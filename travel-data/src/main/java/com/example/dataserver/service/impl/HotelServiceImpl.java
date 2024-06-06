package com.example.dataserver.service.impl;

import com.example.dataserver.mapper.HotelMapper;
import com.example.dataserver.service.HotelService;
import com.example.model.Hotel;
import com.example.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    public HotelMapper hotelMapper;

    @Override
    public List<Hotel> getHotel() {
        return hotelMapper.getHotel();
    }
    public Hotel getHotelById(int id){
        return hotelMapper.getHotelById(id);
    };

    public List<Review> getReviewById(int id){
        return hotelMapper.getReviewById(id);
    };
}

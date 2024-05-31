package com.example.dataserver.service.impl;

import com.example.dataserver.entity.Hotel;
import com.example.dataserver.entity.Spot;
import com.example.dataserver.mapper.HotelMapper;
import com.example.dataserver.service.HotelService;
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
}

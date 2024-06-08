package com.example.dataserver.service.impl;

import com.example.dataserver.mapper.HotelManageMapper;
import com.example.dataserver.mapper.HotelMapper;
import com.example.dataserver.mapper.ScenicSpotMapper;
import com.example.dataserver.service.HotelManageService;
import com.example.dataserver.service.HotelService;
import com.example.model.Hotel;
import com.example.model.ScenicSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelManageServiceImpl implements HotelManageService {
    @Autowired
    HotelManageMapper hotelManageMapper;

    public List<Hotel> getAllHotel(Hotel hotel){
        return hotelManageMapper.getAllHotel(hotel);
    }

    public boolean addHotel(Hotel hotel){
        return hotelManageMapper.addHotel(hotel);
    }

    @Override
    public boolean updateHotel(Hotel hotel) {
        return hotelManageMapper.updateHotel(hotel);
    }
}

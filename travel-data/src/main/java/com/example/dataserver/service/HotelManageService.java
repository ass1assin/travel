package com.example.dataserver.service;

import com.example.model.Hotel;
import com.example.model.ScenicSpot;

import java.util.List;

public interface HotelManageService {
    public List<Hotel> getAllHotel();

    public boolean addHotel(Hotel hotel);

    public boolean updateHotel(Hotel hotel);
}

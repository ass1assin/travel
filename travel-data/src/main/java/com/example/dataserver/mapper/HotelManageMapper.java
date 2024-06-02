package com.example.dataserver.mapper;

import com.example.model.Hotel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotelManageMapper {
    public List<Hotel> getAllHotel();
}

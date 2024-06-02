package com.example.dataserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.model.Hotel;

import java.util.List;

@Mapper
public interface HotelMapper {
    public List<Hotel> getHotel();
}

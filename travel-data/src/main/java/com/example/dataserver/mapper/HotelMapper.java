package com.example.dataserver.mapper;

import com.example.dataserver.entity.Hotel;
import com.example.dataserver.entity.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotelMapper {
    public List<Hotel> getHotel();
}

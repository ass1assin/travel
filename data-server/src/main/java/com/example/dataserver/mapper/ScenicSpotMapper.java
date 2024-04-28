package com.example.dataserver.mapper;

import com.example.dataserver.entity.ScenicSpot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScenicSpotMapper {
    public List<ScenicSpot> getAllSpot();
}

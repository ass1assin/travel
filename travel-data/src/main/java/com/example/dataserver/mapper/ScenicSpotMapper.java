package com.example.dataserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.model.ScenicSpot;

import java.util.List;

@Mapper
public interface ScenicSpotMapper {
    public List<ScenicSpot> getAllSpot();
}

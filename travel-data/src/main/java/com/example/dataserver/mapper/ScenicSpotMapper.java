package com.example.dataserver.mapper;

import com.example.model.Notice;
import org.apache.ibatis.annotations.Mapper;
import com.example.model.ScenicSpot;

import java.util.List;

@Mapper
public interface ScenicSpotMapper {
    public List<ScenicSpot> getAllSpot(ScenicSpot scenicSpot);

    public boolean addSpot(ScenicSpot scenicSpot);

    public boolean updateSpot(ScenicSpot scenicSpot);
}

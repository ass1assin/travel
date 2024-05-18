package com.example.dataserver.service.impl;

import com.example.dataserver.entity.ScenicSpot;
import com.example.dataserver.mapper.ScenicSpotMapper;
import com.example.dataserver.service.ScenicSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenicSpotServiceImpl implements ScenicSpotService {
    @Autowired
    ScenicSpotMapper scenicSpotMapper;

    public List<ScenicSpot> getAllSpot(){
        return scenicSpotMapper.getAllSpot();
    }
}

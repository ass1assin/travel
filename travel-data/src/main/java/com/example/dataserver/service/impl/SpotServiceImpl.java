package com.example.dataserver.service.impl;

import com.example.dataserver.entity.Notice;
import com.example.dataserver.entity.ScenicSpot;
import com.example.dataserver.entity.Spot;
import com.example.dataserver.mapper.ScenicSpotMapper;
import com.example.dataserver.mapper.SpotMapper;
import com.example.dataserver.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {
    @Autowired
    SpotMapper spotMapper;

    public List<Spot> getSpot(){
        return spotMapper.getSpot();
    }

    @Override
    public List<Notice> getNotce() {
        return spotMapper.getNotice();
    }
}

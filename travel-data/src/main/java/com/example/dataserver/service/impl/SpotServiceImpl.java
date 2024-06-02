package com.example.dataserver.service.impl;

import com.example.dataserver.mapper.SpotMapper;
import com.example.dataserver.service.SpotService;
import com.example.model.Notice;
import com.example.model.Spot;
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

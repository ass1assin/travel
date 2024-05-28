package com.example.dataserver.service;

import com.example.dataserver.entity.Notice;
import com.example.dataserver.entity.ScenicSpot;
import com.example.dataserver.entity.Spot;

import java.util.List;

public interface SpotService {
    public List<Spot> getSpot();

    public List<Notice> getNotce();
}

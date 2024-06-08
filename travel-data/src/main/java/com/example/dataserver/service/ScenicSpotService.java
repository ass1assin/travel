package com.example.dataserver.service;


import com.example.model.Notice;
import com.example.model.ScenicSpot;

import java.util.List;

public interface ScenicSpotService {
    public List<ScenicSpot> getAllSpot(ScenicSpot spot);

    public boolean addSpot(ScenicSpot spot);

    public boolean updateSpot(ScenicSpot spot);
}

package com.example.dataserver.service;


import com.example.model.Notice;
import com.example.model.Spot;

import java.util.List;

public interface SpotService {
    public List<Spot> getSpot();

    public List<Notice> getNotce();
}

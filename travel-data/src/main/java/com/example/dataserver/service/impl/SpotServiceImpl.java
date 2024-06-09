package com.example.dataserver.service.impl;

import com.example.dataserver.mapper.SpotMapper;
import com.example.dataserver.service.SpotService;
import com.example.model.Hotel;
import com.example.model.Notice;
import com.example.model.Review;
import com.example.model.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {
    @Autowired
    SpotMapper spotMapper;


    @Override
    public List<Notice> getNotce() {
        return spotMapper.getNotice();
    }

    public List<Spot> getAllSpots(){
        return spotMapper.getAllSpots();
    }

    public Spot getSpotById(int id){
        return spotMapper.getSpotById(id);
    };

    public List<Review> getSpotReviewById(int id){
        return spotMapper.getSpotReviewById(id);
    };

    public boolean saveSpotComment(Review review){
        return spotMapper.saveSpotComment(review);
    };
}

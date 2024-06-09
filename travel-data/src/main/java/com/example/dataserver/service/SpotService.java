package com.example.dataserver.service;


import com.example.model.Hotel;
import com.example.model.Notice;
import com.example.model.Review;
import com.example.model.Spot;

import java.util.List;

public interface SpotService {

    public List<Notice> getNotce();

    public List<Spot> getAllSpots();

    public Spot getSpotById(int id);

    public List<Review> getSpotReviewById(int id);
    public boolean saveSpotComment(Review review);
}

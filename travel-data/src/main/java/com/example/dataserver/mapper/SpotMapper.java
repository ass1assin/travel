package com.example.dataserver.mapper;

import com.example.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpotMapper {

    public List<Notice> getNotice();

    public List<Spot> getAllSpots();

    public Spot getSpotById(int id);
    public List<Review> getSpotReviewById(int id);
    public boolean saveSpotComment(Review review);
}

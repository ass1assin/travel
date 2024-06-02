package com.example.dataserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.model.Notice;
import com.example.model.Spot;

import java.util.List;

@Mapper
public interface SpotMapper {
    public List<Spot> getSpot();

    public List<Notice> getNotice();
}

package com.example.dataserver.mapper;

import com.example.dataserver.entity.Notice;
import com.example.dataserver.entity.ScenicSpot;
import com.example.dataserver.entity.Spot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpotMapper {
    public List<Spot> getSpot();

    public List<Notice> getNotice();
}

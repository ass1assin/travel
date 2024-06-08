package com.example.dataserver.service.impl;

import com.example.dataserver.mapper.HotelMapper;
import com.example.dataserver.mapper.NoticeManageMapper;
import com.example.dataserver.service.NoticeManageService;
import com.example.model.Hotel;
import com.example.model.Notice;
import com.example.model.ScenicSpot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeManageServiceImpl implements NoticeManageService {
    @Autowired
    NoticeManageMapper noticeManageMapper;

    public List<Notice> getAllNotice(Notice notice){
        return noticeManageMapper.getAllNotice(notice);
    }
    public boolean addNotice(Notice notice){
        return noticeManageMapper.addNotice(notice);
    }

    @Override
    public boolean updateNotice(Notice notice){
        return noticeManageMapper.updateNotice(notice);
    }
}

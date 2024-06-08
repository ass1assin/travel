package com.example.dataserver.service;

import com.example.model.Hotel;
import com.example.model.Notice;
import com.example.model.ScenicSpot;

import java.util.List;

public interface NoticeManageService {
    public List<Notice> getAllNotice(Notice notice);

    public boolean addNotice(Notice notice);

    public boolean updateNotice(Notice notice);
}

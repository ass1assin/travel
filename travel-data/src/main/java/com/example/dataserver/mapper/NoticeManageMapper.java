package com.example.dataserver.mapper;

import com.example.model.Hotel;
import com.example.model.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeManageMapper {
    public List<Notice> getAllNotice(Notice notice);

    public boolean addNotice(Notice notice);

    public boolean updateNotice(Notice notice);
}

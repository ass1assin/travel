package com.example.userserver.mapper;


import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findInfo(String username, String password);

    User register(String username, String password);
}

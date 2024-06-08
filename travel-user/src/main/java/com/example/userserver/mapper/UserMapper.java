package com.example.userserver.mapper;


import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findInfo(@Param("username") String username, @Param("password") String password);

    boolean register(@Param("username") String username, @Param("password") String password);

    User getPersonInfo();
}

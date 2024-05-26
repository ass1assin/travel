package com.example.dataserver;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.A;
import com.example.dataserver.controller.ScenicSpotController;
import com.example.dataserver.entity.ScenicSpot;
import com.example.dataserver.mapper.ScenicSpotMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataServerApplicationTests {
@Autowired
    ScenicSpotController scenicSpotController;
@Autowired
    ScenicSpotMapper scenicSpotMapper;

    @Test
    void contextLoads() {
        ScenicSpot scenicSpot = new ScenicSpot();
        scenicSpot.setCurrentPage(1);
        scenicSpot.setPageSize(10);
        System.out.println(scenicSpotController.getAllSpot(scenicSpot));
    }

}

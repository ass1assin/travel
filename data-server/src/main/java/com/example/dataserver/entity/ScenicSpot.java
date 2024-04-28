package com.example.dataserver.entity;

import java.math.BigInteger;

public class ScenicSpot {
    public Long id;
    public String spotName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    @Override
    public String toString() {
        return "ScenicSpot{" +
                "id=" + id +
                ", spotName='" + spotName + '\'' +
                '}';
    }
}

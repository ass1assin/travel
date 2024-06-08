package com.example.model;

public class ScenicSpot {
    public Long id;
    public String spotName;

    public String spotLocation;
    public String spotContent;

    public String imageUrl;


    private int currentPage;

    private int pageSize;

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

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpotLocation() {
        return spotLocation;
    }

    public void setSpotLocation(String spotLocation) {
        this.spotLocation = spotLocation;
    }

    public String getSpotContent() {
        return spotContent;
    }

    public void setSpotContent(String spotContent) {
        this.spotContent = spotContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "ScenicSpot{" +
                "id=" + id +
                ", spotName='" + spotName + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}

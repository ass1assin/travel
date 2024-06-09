package com.example.model;

public class Hotel {
    public Long id;
    public String hotelName;
    public String hotelContent;
    public String imageUrl;

    public double hotelScope;
    public String hotelLocation;

    private int currentPage;

    private int pageSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelContent() {
        return hotelContent;
    }

    public void setHotelContent(String hotelContent) {
        this.hotelContent = hotelContent;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getHotelScope() {
        return hotelScope;
    }

    public void setHotelScope(double hotelScope) {
        this.hotelScope = hotelScope;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", hotelContent='" + hotelContent + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}

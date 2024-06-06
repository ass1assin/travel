package com.example.model;

import java.sql.Timestamp;

public class Review {
    public Long id;

    public String content;

    public String userName;

    private int reviewType;

    private Timestamp reviewTime;

    private Long relationId;

    private String userAvatar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getReviewType() {
        return reviewType;
    }

    public void setReviewType(int reviewType) {
        this.reviewType = reviewType;
    }

    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userName='" + userName + '\'' +
                ", reviewType=" + reviewType +
                ", reviewTime=" + reviewTime +
                ", relationId=" + relationId +
                ", userAvatar='" + userAvatar + '\'' +
                '}';
    }
}

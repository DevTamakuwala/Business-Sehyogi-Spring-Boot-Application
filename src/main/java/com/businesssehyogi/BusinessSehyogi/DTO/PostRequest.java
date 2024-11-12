package com.businesssehyogi.BusinessSehyogi.DTO;

import java.time.LocalDateTime;

public class PostRequest {

    private LocalDateTime dateAndTime;
    private String abstractContent;
    private String content;
    private int noOfLikes;
    private int noOfInterested;
    private boolean visible;
    private int views;
    private boolean boostedPost;
    private int userId; // ID of the user
    private int areaId; // ID of the interest area


    public PostRequest(LocalDateTime dateAndTime, String abstractContent, String content, int noOfLikes, int noOfInterested, boolean visible, int views, boolean boostedPost, int userId, int areaId) {
        this.dateAndTime = dateAndTime;
        this.abstractContent = abstractContent;
        this.content = content;
        this.noOfLikes = noOfLikes;
        this.noOfInterested = noOfInterested;
        this.visible = visible;
        this.views = views;
        this.boostedPost = boostedPost;
        this.userId = userId;
        this.areaId = areaId;
    }

    public PostRequest() {
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNoOfLikes() {
        return noOfLikes;
    }

    public void setNoOfLikes(int noOfLikes) {
        this.noOfLikes = noOfLikes;
    }

    public int getNoOfInterested() {
        return noOfInterested;
    }

    public void setNoOfInterested(int noOfInterested) {
        this.noOfInterested = noOfInterested;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isBoostedPost() {
        return boostedPost;
    }

    public void setBoostedPost(boolean boostedPost) {
        this.boostedPost = boostedPost;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }
}

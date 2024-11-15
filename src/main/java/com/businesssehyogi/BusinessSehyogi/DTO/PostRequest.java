package com.businesssehyogi.BusinessSehyogi.DTO;

import java.time.LocalDateTime;

public class PostRequest {

    private LocalDateTime dateAndTime;
    private String abstractContent;
    private String content;
    private Long noOfLikes;
    private Long noOfInterested;
    private Long noOfComments;
    private boolean visible;
    private int views;
    private boolean boostedPost;
    private int userId; // ID of the user
    private int areaId; // ID of the interest area


    public PostRequest(LocalDateTime dateAndTime, String abstractContent, String content, Long noOfLikes, Long noOfInterested, Long noOfComments, boolean visible, int views, boolean boostedPost, int userId, int areaId) {
        this.dateAndTime = dateAndTime;
        this.abstractContent = abstractContent;
        this.content = content;
        this.noOfLikes = noOfLikes;
        this.noOfInterested = noOfInterested;
        this.noOfComments = noOfComments;
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

    public Long getNoOfLikes() {
        return noOfLikes;
    }

    public void setNoOfLikes(Long noOfLikes) {
        this.noOfLikes = noOfLikes;
    }

    public Long getNoOfInterested() {
        return noOfInterested;
    }

    public void setNoOfInterested(Long noOfInterested) {
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

    public Long getNoOfComments() {
        return noOfComments;
    }

    public void setNoOfComments(Long noOfComments) {
        this.noOfComments = noOfComments;
    }
}

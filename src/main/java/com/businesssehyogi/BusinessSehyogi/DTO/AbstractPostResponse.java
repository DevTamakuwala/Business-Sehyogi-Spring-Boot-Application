package com.businesssehyogi.BusinessSehyogi.DTO;

import java.time.LocalDateTime;

public class AbstractPostResponse {
    private int postId;
    private LocalDateTime dateAndTime;
    private String abstractContent;
    private int noOfLikes;
    private int noOfInterested;
    private boolean visible;
    private int views;
    private boolean boostedPost;

    // Constructor
    public AbstractPostResponse(int postId, LocalDateTime dateAndTime, String abstractContent, int noOfLikes, int noOfInterested, boolean visible, int views, boolean boostedPost) {
        this.postId = postId;
        this.dateAndTime = dateAndTime;
        this.abstractContent = abstractContent;
        this.noOfLikes = noOfLikes;
        this.noOfInterested = noOfInterested;
        this.visible = visible;
        this.views = views;
        this.boostedPost = boostedPost;
    }

    public AbstractPostResponse() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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
}
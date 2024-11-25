package com.businesssehyogi.BusinessSehyogi.DTO;

import com.businesssehyogi.BusinessSehyogi.model.User;

import java.time.LocalDateTime;

public class AbstractPostResponse {
    private int postId;
    private LocalDateTime dateAndTime;
    private String abstractContent;
    private Long noOfLikes;
    private Long noOfInterested;
    private Long noOfComments;
    private boolean visible;
    private int views;
    private boolean boostedPost;
    private User user;

    // Constructor
    public AbstractPostResponse(int postId, LocalDateTime dateAndTime, String abstractContent, Long noOfLikes, Long noOfInterested, Long noOfComments, boolean visible, int views, boolean boostedPost, User user) {
        this.postId = postId;
        this.dateAndTime = dateAndTime;
        this.abstractContent = abstractContent;
        this.noOfLikes = noOfLikes;
        this.noOfInterested = noOfInterested;
        this.noOfComments = noOfComments;
        this.visible = visible;
        this.views = views;
        this.boostedPost = boostedPost;
        this.user = user;
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

    public Long getNoOfComments() {
        return noOfComments;
    }

    public void setNoOfComments(Long noOfComments) {
        this.noOfComments = noOfComments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
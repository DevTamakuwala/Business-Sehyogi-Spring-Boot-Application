package com.businesssehyogi.BusinessSehyogi.DTO;

import com.businesssehyogi.BusinessSehyogi.model.Images;
import com.businesssehyogi.BusinessSehyogi.model.Links;

import java.time.LocalDateTime;
import java.util.List;

public class FullPostResponse {
    private int postId;
    private LocalDateTime dateAndTime;
    private String abstractContent;
    private String content;
    private int noOfLikes;
    private int noOfInterested;
    private boolean visible;
    private int views;
    private boolean boostedPost;
    private List<Images> images;
    private List<Links> links;

    // Constructor
    public FullPostResponse(int postId, LocalDateTime dateAndTime, String abstractContent, String content, int noOfLikes, int noOfInterested, boolean visible, int views, boolean boostedPost, List<Images> images, List<Links> links) {
        this.postId = postId;
        this.dateAndTime = dateAndTime;
        this.abstractContent = abstractContent;
        this.content = content;
        this.noOfLikes = noOfLikes;
        this.noOfInterested = noOfInterested;
        this.visible = visible;
        this.views = views;
        this.boostedPost = boostedPost;
        this.images = images;
        this.links = links;
    }

    public FullPostResponse() {
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

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public List<Links> getLinks() {
        return links;
    }

    public void setLinks(List<Links> links) {
        this.links = links;
    }

    // Getters and setters omitted for brevity
}
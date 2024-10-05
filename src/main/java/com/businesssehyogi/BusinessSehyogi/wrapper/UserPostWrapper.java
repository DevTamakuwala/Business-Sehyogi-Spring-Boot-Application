package com.businesssehyogi.BusinessSehyogi.wrapper;

import com.businesssehyogi.BusinessSehyogi.model.Post;
import com.businesssehyogi.BusinessSehyogi.model.User;

public class UserPostWrapper {

    private User user;
    private Post post;

    public UserPostWrapper() {
    }

    public UserPostWrapper(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

package com.businesssehyogi.BusinessSehyogi.DTO;

public class loginDTO {
    private int user_id;
    private String email;
    private String password;
    private String category;
    private boolean visible;

    public loginDTO(int userId, String email, String password, String category, boolean visible) {
        this.user_id = userId;
        this.email = email;
        this.password = password;
        this.category = category;
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "loginDTO{" +
                "userId=" + user_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", visible=" + visible +
                '}';
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

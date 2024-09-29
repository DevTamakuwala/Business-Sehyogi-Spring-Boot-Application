package com.businesssehyogi.BusinessSehyogi.DTO;

public class loginDTO {
    private int userId;
    private String userName;
    private String password;
    private String category;
    private boolean visible;

    public loginDTO(int userId, String userName, String password, String category, boolean visible) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.category = category;
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "loginDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", visible=" + visible +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

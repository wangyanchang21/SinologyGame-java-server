package com.weapp.dto;

public class User {

    public Long userId;
    public String userName;
    public String userAvatar;
    public Long userLevel;
    public Long bestPass;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Long getUserLevel() {
        return userLevel;
    }
    public void setUserLevel(Long userLevel) {
        this.userLevel = userLevel;
    }

    public Long getBestPass() {
        return bestPass;
    }
    public void setBestPass(Long bestPass) {
        this.bestPass = bestPass;
    }

}
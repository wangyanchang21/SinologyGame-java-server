package com.weapp.service;

import com.weapp.dto.User;

public interface UserService {

    // User
    public String createUser(User user);
    public String getUserRankList();
    public String getUserInfo(Long openId);
    public String updateUserInfo(User user);
}
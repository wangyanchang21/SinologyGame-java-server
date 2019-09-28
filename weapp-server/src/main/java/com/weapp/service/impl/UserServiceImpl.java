package com.weapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.weapp.service.UserService;
import com.weapp.dao.UserMapper;
import com.weapp.dto.User;

import java.util.List;

import com.util.ResponseUtil;
import com.util.StatusCode;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    // User
    public String createUser(User user) {
        if (user.openId != null && !StringUtils.isEmpty(user.userName)) {
            try {
                Long one = Long.valueOf(1);
                user.setUserLevel(one);
                user.setCurrentPass(one);
                user.setBestPass(one);
                userMapper.insert(user);
                return ResponseUtil.success();
            } catch (DataAccessException e) {
                System.err.println(e);
                return ResponseUtil.error(e.getMessage(), StatusCode.SQL_ERROR);
            } catch (Exception e) {
                System.err.println(e);
                return ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            }
        } else {
            return ResponseUtil.error("openId or userName is uncorrect", StatusCode.PARAMETERE_ERROR);
        }
    }

    public String getUserRankList() {
        try {
            List<User>users = userMapper.getUserRankList();
            return ResponseUtil.success(users);
        } catch (DataAccessException e) {
            System.err.println(e);
            return ResponseUtil.error(e.getMessage(), StatusCode.SQL_ERROR);
        } catch (Exception e) {
            System.err.println(e);
            return ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
        }
    }

    public String getUserInfo(Long openId) {
        try {
            User user = userMapper.getUser(openId);
            return ResponseUtil.success(user);
        } catch (DataAccessException e) {
            System.err.println(e);
            return ResponseUtil.error(e.getMessage(), StatusCode.SQL_ERROR);
        } catch (Exception e) {
            System.err.println(e);
            return ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
        }
    }

    public String updateUserInfo(User user) {
        if (user.openId != null) {
            try {
                userMapper.update(user);
                return ResponseUtil.success();
            } catch (DataAccessException e) {
                System.err.println(e);
                return ResponseUtil.error(e.getMessage(), StatusCode.SQL_ERROR);
            } catch (Exception e) {
                System.err.println(e);
                return ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            }
        } else {
            return ResponseUtil.error("openId is uncorrect", StatusCode.PARAMETERE_ERROR);
        }
    }

}
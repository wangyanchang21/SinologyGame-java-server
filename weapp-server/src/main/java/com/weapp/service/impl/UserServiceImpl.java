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
                User oldUser = userMapper.getUser(user.openId);
                if (null == oldUser) {
                    Long one = Long.valueOf(1);
                    user.setUserLevel(one);
                    user.setCurrentPass(one);
                    user.setBestPass(one);
                    userMapper.insert(user);
                    return ResponseUtil.success();
                } else {
                    return ResponseUtil.error("old user, don't need to create", StatusCode.ALREADY_DID_ERROR);
                }
            } catch (DataAccessException e) {
                System.err.println(e);
                return ResponseUtil.error(e.getMessage(), StatusCode.SQL_ERROR);
            } catch (Exception e) {
                System.err.println(e);
                return ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            }
        } else {
            return ResponseUtil.error("openId or userName is incorrect", StatusCode.PARAMETERE_ERROR);
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

    public String getUserInfo(String openId) {
        try {
            User user = userMapper.getUser(openId);
            if (null == user) {
                return ResponseUtil.error("没有对应的数据", StatusCode.NOT_FIND_ERROR);
            } else {
                return ResponseUtil.success(user);
            }
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
                User oldUser = userMapper.getUser(user.openId);
                if (null == oldUser) {
                    return ResponseUtil.error("没有对应的数据", StatusCode.NOT_FIND_ERROR);
                }
                if (user.userName != null) {
                    oldUser.setUserName(user.userName);
                }
                if (user.userAvatar != null) {
                    oldUser.setUserAvatar(user.userAvatar);
                }
                if (user.currentPass != null) {
                    oldUser.setCurrentPass(user.currentPass);
                }
                // bestPass规则
                if (user.currentPass != null && user.currentPass > oldUser.bestPass) {
                    oldUser.setBestPass(user.currentPass);
                }
                // leve规则
                if (oldUser.bestPass <= 20) {
                    oldUser.setUserLevel(Long.valueOf(1));
                } else if (oldUser.bestPass <= 50) {
                    oldUser.setUserLevel(Long.valueOf(2));
                } else if (oldUser.bestPass <= 100) {
                    oldUser.setUserLevel(Long.valueOf(3));
                } else if (oldUser.bestPass <= 200) {
                    oldUser.setUserLevel(Long.valueOf(4));
                } else {
                    oldUser.setUserLevel(Long.valueOf(5));
                }

                userMapper.update(oldUser);
                return ResponseUtil.success();
            } catch (DataAccessException e) {
                System.err.println(e);
                return ResponseUtil.error(e.getMessage(), StatusCode.SQL_ERROR);
            } catch (Exception e) {
                System.err.println(e);
                return ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            }
        } else {
            return ResponseUtil.error("openId is incorrect", StatusCode.PARAMETERE_ERROR);
        }
    }

}
package com.weapp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.weapp.dto.User;


public interface UserMapper {

	@Select("SELECT * FROM users")
    List<User> getUserList();

	@Insert("INSERT INTO users(openId, userName, userAvatar, userLevel, bestPass) VALUES(#{openId}, #{userName}, #{userAvatar}, #{userLevel}, #{bestPass})")
	void insert(User user);

	@Select("SELECT * FROM users WHERE openId = #{openId}")
	User getUser(Long openId);

	@Delete("DELETE FROM users WHERE openId = #{openId}")
	void delete(Long openId);

}
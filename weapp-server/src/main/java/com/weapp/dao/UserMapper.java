package com.weapp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.weapp.dto.User;


public interface UserMapper {

	@Select("SELECT * from users ORDER BY bestPass DESC LIMIT 0,14")
	List<User> getUserRankList();

	@Insert("INSERT INTO users(openId, userName, userAvatar, userLevel, currentPass, bestPass) VALUES(#{openId}, #{userName}, #{userAvatar}, #{userLevel}, #{currentPass}, #{bestPass})")
	void insert(User user);

	@Select("SELECT * FROM users WHERE openId = #{openId}")
	User getUser(String openId);

	@Update("UPDATE users SET userName=#{userName}, userAvatar=#{userAvatar}, currentPass=#{currentPass}, bestPass=#{bestPass}, userLevel=#{userLevel} WHERE openId =#{openId}")
	void update(User user);

	// standby
	@Select("SELECT * FROM users")
	List<User> getUserList();
	
	@Delete("DELETE FROM users WHERE openId = #{openId}")
	void delete(String openId);

}
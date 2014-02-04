package com.myspace.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myspace.model.User;

public interface UserMapper {

	public User selectUserByID(@Param("userId")Long userId);
	
	public List<User> selectUserByGroupID(@Param("groupId")Long groupId);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public User selectUserByUserNameAndPwd(User user);
}

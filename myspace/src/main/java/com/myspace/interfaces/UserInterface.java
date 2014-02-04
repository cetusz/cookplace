package com.myspace.interfaces;

import java.util.List;

import com.myspace.model.User;

public interface UserInterface {

	public User selectUserByID(Long userId);
	
	public List<User> selectUserByGroupID(Long groupId);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public User selectUserByUserNameAndPwd(User user);
}

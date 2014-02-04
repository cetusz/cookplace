package com.myspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myspace.interfaces.UserInterface;
import com.myspace.mapper.UserMapper;
import com.myspace.model.User;

@Service
public class UserService implements UserInterface{

	@Autowired UserMapper userMapper;
	
	@Transactional
	public void addUser(User user){
		userMapper.addUser(user);
	}

	@Override
	public User selectUserByID(Long userId) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByID(userId);
	}

	@Override
	public List<User> selectUserByGroupID(Long groupId) {
		return userMapper.selectUserByGroupID(groupId);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);		
	}

	@Override
	public User selectUserByUserNameAndPwd(User user) {
		// TODO Auto-generated method stub
		return userMapper.selectUserByUserNameAndPwd(user);
	}
	
	
}

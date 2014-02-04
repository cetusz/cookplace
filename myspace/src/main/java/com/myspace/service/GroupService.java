package com.myspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myspace.interfaces.GroupInterface;
import com.myspace.mapper.GroupMapper;
import com.myspace.model.Group;
import com.myspace.model.User;

@Service
public class GroupService implements GroupInterface{
	
	@Autowired GroupMapper groupMapper;
	
	@Transactional
	public void addGroup(Group group){
		groupMapper.addGroup(group);
	}
	
	
	public Group getGroupById(Long groupId){
		return groupMapper.getGroupById(groupId);
	}


	@Override
	public List<User> getUsersByGroup(Long groupId) {
		// TODO Auto-generated method stub
		return groupMapper.getUsersByGroup(groupId);
	}


	@Override
	public Group selectGroupAndUsers(Long groupId) {
		// TODO Auto-generated method stub
		return groupMapper.selectGroupAndUsers(groupId);
	}


	@Override
	public Group getGroupUsers(Long groupId) {
		// TODO Auto-generated method stub
		return groupMapper.getGroupUsers(groupId);
	}

}

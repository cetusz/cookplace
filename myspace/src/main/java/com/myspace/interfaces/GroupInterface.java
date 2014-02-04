package com.myspace.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myspace.model.Group;
import com.myspace.model.User;

public interface GroupInterface {

public void addGroup(Group group);
	
	public Group getGroupById(Long groupId);
	
	public Group selectGroupAndUsers(Long groupId);
	
	public Group getGroupUsers(Long groupId);
	
	public List<User> getUsersByGroup(Long groupId);
}

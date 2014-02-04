package com.myspace.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myspace.model.Group;
import com.myspace.model.User;

public interface GroupMapper {
	
	public void addGroup(Group group);
	
	public Group getGroupById(@Param("groupId")Long groupId);
	
	public Group selectGroupAndUsers(@Param("groupId")Long groupId);
	
	public Group getGroupUsers(@Param("groupId")Long groupId);
	
	public List<User> getUsersByGroup(@Param("groupId")Long groupId);
	
	
}

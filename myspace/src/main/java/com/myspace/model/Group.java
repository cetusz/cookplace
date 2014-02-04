package com.myspace.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8120014812311649606L;
	
	private Long groupId;
	private String groupName;
	private List<User> users = new ArrayList<User>();
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}

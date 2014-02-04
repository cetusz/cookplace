package myspace;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.myspace.model.Group;
import com.myspace.model.User;



public class TestJson {

	@Test
	public void testJson(){
		  User user = new User();
		  user.setUserName("cetus");
		  user.setPwd("123445");
		  
		  Group group = new Group();
		  group.setGroupName("my");
		  group.setGroupId(1L);
		  
		  user.setGroup(group);
		  
		  List<User> users = new ArrayList<User>();
	      users.add(user);
		  group.setUsers(users);
		  
		  System.out.println(JSON.toJSONString(user));
		  System.out.println(JSON.toJSONString(group));
	}
}

package myspace;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.myspace.interfaces.GroupInterface;
import com.myspace.interfaces.UserInterface;
import com.myspace.model.Group;
import com.myspace.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml", "classpath:/spring/spring-mvc-context.xml"}) 
public class TestService {
	@Autowired GroupInterface groupService;
	@Autowired UserInterface userService;

	@Test
	public void testAddGroup(){
		Group group = new Group();
		group.setGroupName("group one");
		groupService.addGroup(group);
		
	}
	@Test
	public void testAddUser(){
		Group group = groupService.getGroupById(1L);
		Assert.notNull(group);
		
		User user = new User();
		user.setGroupId(group.getGroupId());
		user.setPwd("admin");
		user.setUserName("admin");
		userService.addUser(user);
	}
	
	@Test
	public void testAddUsers(){
		Group group = groupService.getGroupById(1L);
		Assert.notNull(group);
		for(int i=0;i<100;i++){
			User user = new User();
			user.setGroupId(group.getGroupId());
			user.setPwd("111111");
			user.setUserName("user_"+i);
			userService.addUser(user);
		}
	}
	@Test
	public void testLoadUser(){
		User user = userService.selectUserByID(1L);
		Assert.notNull(user.getGroup());
		Assert.isTrue(user.getGroup().getGroupId()==1L);
	}
	
	@Test
	public void testLoadGroup(){
		Group group = groupService.selectGroupAndUsers(1L);
		Assert.notNull(group.getUsers());
		Assert.isTrue(group.getUsers().size()>0);
		
	}
	
	@Test
	public void testGroupUsers(){
		Group group = groupService.getGroupUsers(1L);
		Assert.notNull(group.getUsers());
		Assert.isTrue(group.getUsers().size()>0);
		
	}
}

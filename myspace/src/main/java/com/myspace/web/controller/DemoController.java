package com.myspace.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myspace.interfaces.UserInterface;
import com.myspace.model.User;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	public UserInterface userService;
	
	@RequestMapping("/{name}/{age}")
	public @ResponseBody Map<String,Object> getJson(@PathVariable("name")String name,@PathVariable("age")Long age){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("name", name);
		result.put("age", age);
		return result;
	}
	@RequestMapping("/demo")
	public String toDemoPage(){
		return "/demo";
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute("User") User user){
		userService.addUser(user);
		return "redirect:/demo/demo";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(@ModelAttribute("User") User user,HttpServletRequest request){
		User currentUser = userService.selectUserByUserNameAndPwd(user);
		request.getSession().setAttribute("User", currentUser);
		return "redirect:/index";
	}
}

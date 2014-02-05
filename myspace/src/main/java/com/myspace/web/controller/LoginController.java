package com.myspace.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspace.model.User;
import com.myspace.service.UserService;

@Controller
@RequestMapping("/entry")
public class LoginController {

	@Autowired UserService userService;
	@RequestMapping(value="/tologin",method=RequestMethod.GET)
	public String tologin(){
		return "entry/login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute User user,HttpServletRequest request){
		User currentUser = userService.selectUserByUserNameAndPwd(user);
		if(currentUser!=null){
			return "redirect:/admin/index";
		}
		return "entry/login";
	}
	
	
}

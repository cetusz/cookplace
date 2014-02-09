package com.myspace.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@RequestMapping(value="/login")
	public String login(@ModelAttribute User user,ModelAndView model,
			HttpServletRequest request,
			final RedirectAttributes redirectAttributes){
		User currentUser = userService.selectUserByUserNameAndPwd(user);
		if(currentUser!=null){
			request.getSession().setAttribute("user", currentUser);
			redirectAttributes.addFlashAttribute("test","success");
			redirectAttributes.addFlashAttribute("user",currentUser);
			model.addObject("test", "test-post-modelview");
			return "redirect:/index/index";
		}
		return "entry/login";
	}
	
	@RequestMapping(value="/logout")
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException{
		request.getSession().removeAttribute("UserName");
		response.sendRedirect(request.getContextPath()+"/entry/tologin");
	}
	
	
}

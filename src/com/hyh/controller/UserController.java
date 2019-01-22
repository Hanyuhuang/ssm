package com.hyh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyh.entity.User;
import com.hyh.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,User user) {
		user = userService.login(user);
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			return "redirect:itemList.action";
		}else {
			String error = "用户名或密码错误";
			request.setAttribute("error", error);
			return "login";
		}	
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}

package com.ja.finalproject.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.user.service.UserServiceImpl;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Autowired
	private UserServiceImpl userSerivce;
	
	
	@RequestMapping("loginPage")
	public String loginPage() {
		
		return "user/loginPage"; //JSP 포워딩
	}
	
	@RequestMapping("registerPage")
	public String registerPage() {
		
		return "user/registerPage";
	}
	
	@RequestMapping("registerProcess")
	public String registerProcess(UserDto params) {
		
		System.out.println("registerProcess - 실행됨!");
		System.out.println(params.getUserid());
		System.out.println(params.getPassword());
		
		userSerivce.register(params);
		
		return "redirect:./loginPage";
//		return "user/loginPage";
	}
	
	@RequestMapping("loginProcess")
	public String loginProcess(HttpSession session, UserDto params) {
		
		UserDto sessionUser = userSerivce.getUserInfoByUserIdAndPassword(params);
		
		if(sessionUser == null) {
			return "user/loginFail";
		}else {
			session.setAttribute("sessionUserInfo", sessionUser);
			return "redirect:../board/mainPage";
		}
		
	}
	
	@RequestMapping("logoutProcess")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate(); // 세션 날림
		
		return "redirect:../board/mainPage";
	}
	
}










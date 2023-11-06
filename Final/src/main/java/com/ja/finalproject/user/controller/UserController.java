package com.ja.finalproject.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String registerPage(Model model) {
		
		model.addAttribute("hobbyList", userSerivce.getHobbyList());		
		
		return "user/registerPage";
	}
	
	@RequestMapping("registerProcess")
	public String registerProcess(UserDto params, int[] hobby_id) {
		
		userSerivce.register(params, hobby_id);
		
//		return "redirect:./loginPage";
		return "user/registerComplete";
	}
	
	@RequestMapping("loginProcess")
	public String loginProcess(HttpSession session, UserDto params) {
		
		UserDto sessionUser = userSerivce.getUserInfoByUserIdAndPassword(params);
		
		if(sessionUser == null) {
			//아이디 혹은 비밀번호가 잘못된 경우
			return "user/loginFail";
		}else {
			//정상 인증 된 경우
			session.setAttribute("sessionUserInfo", sessionUser);
			return "redirect:../board/mainPage";
		}
		
	}
	
	@RequestMapping("logoutProcess")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate(); // 세션 날림
		
		return "redirect:../board/mainPage";
	}
	
	@RequestMapping("mailAuthProcess")
	public String mailAuthProcess(String key) {
		
		userSerivce.authenticateMail(key);
		
		return "user/authComplete";
	}
	
}










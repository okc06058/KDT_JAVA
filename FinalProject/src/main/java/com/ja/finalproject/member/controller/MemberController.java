package com.ja.finalproject.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.finalproject.dto.HobbyCategoryDto;
import com.ja.finalproject.dto.MemberDto;
import com.ja.finalproject.member.service.MemberServiceImpl;

@Controller
@RequestMapping("member/*")
public class MemberController {

	@Autowired
	private MemberServiceImpl memberService;
	
	
	@RequestMapping("loginPage")
	public String loginPage() {
		return "member/loginPage";
	}

	@RequestMapping("registerPage")
	public String registerPage(Model model) {
		
//		List<HobbyCategoryDto> list = memberService.getHobbyList();
//		model.addAttribute("hobbyList", list);
		
		model.addAttribute("hobbyList", memberService.getHobbyList());
		
		return "member/registerPage";
	}
	
	@RequestMapping("registerProcess")
	public String registerProcess(MemberDto params, int [] hobby_id) {
		
		System.out.println("registerProcess called");
		System.out.println(params.getUser_id());
		System.out.println(params.getUser_pw());
		System.out.println(params.getNickname());
		
		memberService.register(params, hobby_id);
		
		return "member/registerComplete";
	}

	@RequestMapping("loginProcess")
	public String loginProcess(HttpSession session, MemberDto params) {
		
		MemberDto sessionUser = memberService.getMemberByIdAndPw(params);
		
		if(sessionUser == null) {
			// 인증 실패
			return "member/loginFail";
		}else {
			// 인증 성공
			session.setAttribute("sessionUser", sessionUser);
			return "redirect:../board/mainPage";
		}
	}
	
	@RequestMapping("logoutProcess")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:../board/mainPage";
	}
	
	@RequestMapping("successMail")
	public String successMail(String key) {
		
		memberService.successMail(key);
		
		return "member/completeMailAuth";
	}
	
}










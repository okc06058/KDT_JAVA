package com.ja.finalproject.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.finalproject.admin.mapper.AdminSqlMapper;
import com.ja.finalproject.admin.service.AdminServiceImpl;
import com.ja.finalproject.board.mapper.BoardSqlMapper;
import com.ja.finalproject.dto.AdminDto;
import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserDto;


@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminSerivce;
	
	@Autowired
	private AdminSqlMapper adminSqlMapper; 
	
	@RequestMapping("adminMainPage")
	public String adminMainPage() {
		
		return "admin/adminMainPage";
	}
	
	
	@RequestMapping("adminLoginPage")
	public String adminLoginPage() {
		
		return "admin/adminLoginPage"; //JSP 포워딩
	}
	
	@RequestMapping("adminRegisterPage")
	public String adminRegisterPage() {
		
		return "admin/adminRegisterPage";
	}
	
	@RequestMapping("adminRegisterProcess")
	public String adminRegisterProcess(AdminDto params) {
		
		System.out.println("adminRegisterProcess - 실행됨!");
		System.out.println(params.getUserid());
		System.out.println(params.getPassword());
		
		adminSerivce.register(params);
		
		return "redirect:./adminLoginPage";
	}
	
	@RequestMapping("adminLoginProcess")
	public String adminLoginProcess(HttpSession session, AdminDto params) {
		
		AdminDto sessionUser = adminSerivce.getUserInfoByUserIdAndPassword(params);
		
		if(sessionUser == null) {
			return "admin/adminLoginFail";
		}else {
			session.setAttribute("sessionAdminInfo", sessionUser);
			return "redirect:../admin/adminMainPage";
		}
		
	}
	
	@RequestMapping("adminLogoutProcess")
	public String adminLogoutProcess(HttpSession session) {
		
		session.invalidate(); // 세션 날림
		
		return "redirect:../admin/adminMainPage";
	}
	
	@RequestMapping("writeArticlePage")
	public String writeArticlePage() {
		
		return "admin/writeArticlePage";
	}
	
	
	@RequestMapping("writeArticleProcess")
	public String writeArticleProcess(HttpSession session, FreeboardArticleDto params) {
		
		AdminDto sessionUserInfo = (AdminDto)session.getAttribute("sessionAdminInfo");
		int userPk = sessionUserInfo.getId();
		
		params.setUser_id(userPk);
		
		adminSerivce.writeArticle(params);
	
		return "redirect:./adminMainPage";
	}
	
	@RequestMapping("readArticlePage")
	public String readArticlePage(Model model, int id) {
		
		adminSerivce.increaseReadCount(id);
		
		Map<String, Object> map = adminSerivce.getArticle(id);
		
		model.addAttribute("qwer", map);		
		
		return "admin/readArticlePage";
	}
	
	@RequestMapping("deleteArticleProcess")
	public String deleteArticleProcess(int id) {
		
		boardService.deleteArticle(id);
		
		return "redirect:./mainPage";
	}
	
	@RequestMapping("updateArticlePage")
	public String updateArticlePage(Model model, int id) {
		
//		Map<String, Object> map = boardService.getArticle(id);
//		model.addAttribute("qwer", map);
		
		model.addAttribute("qwer", boardService.getArticle(id));		
		
		return "board/updateArticlePage";
	}
	
	@RequestMapping("updateArticleProcess")
	public String updateArticleProcess(FreeboardArticleDto params) {
		
		boardService.updateArticle(params);
		
		return "redirect:./readArticlePage?id=" + params.getId();
	}
	
	
}

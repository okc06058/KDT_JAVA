package com.ja.finalproject.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ja.finalproject.admin.mapper.AdminSqlMapper;
import com.ja.finalproject.admin.service.AdminServiceImpl;
import com.ja.finalproject.board.service.BoardServiceImpl;
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
	
	@Autowired
	private BoardServiceImpl boardService; 
	
	@RequestMapping("adminMainPage")
	public String adminMainPage() {
		
		//model.addAttribute("ShopSertchList",adminSerivce.getShopList(params.getUser_id()));
		
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
	public String writeArticlePage(Model model) {
		
		model.addAttribute("categoryList",adminSerivce.getCategoryList());
		
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
		
		boardService.increaseReadCount(id);
		
		Map<String, Object> map = boardService.getArticle(id);
		
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
	
		model.addAttribute("qwer", boardService.getArticle(id));		
		
		return "board/updateArticlePage";
	}
	
	@RequestMapping("updateArticleProcess")
	public String updateArticleProcess(FreeboardArticleDto params) {
		
		boardService.updateArticle(params);
		
		return "redirect:./readArticlePage?id=" + params.getId();
	}
	

}

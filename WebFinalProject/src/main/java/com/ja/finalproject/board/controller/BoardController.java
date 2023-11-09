package com.ja.finalproject.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.finalproject.board.service.BoardServiceImpl;
import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserDto;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardServiceImpl boardService; 
	
	@RequestMapping("mainPage")
	public String mainPage(Model model) {
		//.. 사실상 제일 코드가 많은 구간
		
		List<Map<String, Object>> list = boardService.getArticleList();
		
		model.addAttribute("list", list);
		
		return "board/mainPage";
	}
	
	@RequestMapping("writeArticlePage")
	public String writeArticlePage() {
		
		return "board/writeArticlePage";
	}
	
	@RequestMapping("writeArticleProcess")
	public String writeArticleProcess(HttpSession session, FreeboardArticleDto params) {
		
		UserDto sessionUserInfo = (UserDto)session.getAttribute("sessionUserInfo");
		int userPk = sessionUserInfo.getId();
		
		params.setUser_id(userPk);
		
		boardService.writeArticle(params);
		
//		return "board/writeArticleComplete";
		
		return "redirect:./mainPage";
//		return "board/mainPage";
	}
	
	@RequestMapping("readArticlePage")
	public String readArticlePage(Model model, int id) {
		
		boardService.increaseReadCount(id);
		
		Map<String, Object> map = boardService.getArticle(id);
		
		model.addAttribute("qwer", map);		
		
		return "board/readArticlePage";
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






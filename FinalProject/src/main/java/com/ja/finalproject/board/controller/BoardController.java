package com.ja.finalproject.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.finalproject.board.mapper.BoardSqlMapper;
import com.ja.finalproject.board.service.BoardServiceImp1;
import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserDto;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardServiceImp1 boardService;
	
	@RequestMapping("mainPage")
	public String mainPage(Model model) {
		//..사실상 제일 코드가 많은 구간
		List<Map<String,Object>> list = boardService.getArticleList();
		
		model.addAttribute("list",list);
		
		return "board/mainPage";
	}
	
	@RequestMapping("writeArticlePage")
	public String writeArticlePage() {
		return "board/writeArticlePage";
	}
	
	@RequestMapping("writeArticleProcess")
	public String writeArticleProcess(HttpSession session, FreeboardArticleDto params) {
		
		UserDto sessionUserInfo= (UserDto)session.getAttribute("sessionUserInfo");
		int userPK = sessionUserInfo.getId();
		params.setUser_id(userPK);
		
		
		boardService.writeArticle(params);
		
		
		return "board/writeArticleComplete";
	}

	
}

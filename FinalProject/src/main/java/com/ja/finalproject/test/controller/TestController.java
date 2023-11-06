package com.ja.finalproject.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ja.finalproject.board.service.BoardServiceImpl;
import com.ja.finalproject.user.service.UserServiceImpl;

@Controller
@RequestMapping("/test/*")
public class TestController {
	
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private BoardServiceImpl boardService;
	
	
	
	@ResponseBody
	@RequestMapping("test1")
	public String test1() {
		
		return "qwer";
	}
	
	
	@ResponseBody // RestAPI
	@RequestMapping("getArticleList")
	public List<Map<String, Object>> getArticleList() {
		List<Map<String, Object>> list = boardService.getArticleList(1, null, null);
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping("getArticle")
	public Map<String, Object> getArticle(int id){
		return boardService.getArticle(id);
	}
	
}














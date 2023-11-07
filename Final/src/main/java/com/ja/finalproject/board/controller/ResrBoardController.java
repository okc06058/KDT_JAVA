package com.ja.finalproject.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja.finalproject.board.service.BoardServiceImpl;
import com.ja.finalproject.dto.CommentDto;
import com.ja.finalproject.dto.RestResponseDto;
import com.ja.finalproject.dto.UserDto;


@RestController
@RequestMapping("/board/*")
public class ResrBoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	
	
	@RequestMapping("getCommentList")
	public RestResponseDto getCommentList(int article_id) {
		RestResponseDto restResponseDto = new RestResponseDto();
	
		restResponseDto.setData(boardService.getCommentList(article_id));
		
		restResponseDto.setResult("success");
		return restResponseDto;
	}
	
	public RestResponseDto templete() {
		RestResponseDto restResponseDto = new RestResponseDto();
	
		restResponseDto.setResult("success");
		return restResponseDto;
	}
	
	@RequestMapping("writeComment")
	public RestResponseDto writeComment(HttpSession session, CommentDto params ) {
		RestResponseDto restResponseDto = new RestResponseDto();
		
		UserDto sessionUser = (UserDto)session.getAttribute("sessionUser");
		int userPk=sessionUser.getId();
		
		params.setUser_id(userPk);
		
		boardService.writeComment(params);
	
		restResponseDto.setResult("success");
		return restResponseDto;
	}
	
	@RequestMapping("deleteComment")
	public RestResponseDto deleteComment(int comment_id) {
		RestResponseDto restResponseDto = new RestResponseDto();
	
		boardService.deleteComment(comment_id);
		
		restResponseDto.setResult("success");
		return restResponseDto;
	}
	
	@RequestMapping("updateComment")
	public RestResponseDto updateComment(CommentDto params) {
		RestResponseDto restResponseDto = new RestResponseDto();
	
		boardService.updateComment(params);
		
		restResponseDto.setResult("success");
		return restResponseDto;
	}
	
}

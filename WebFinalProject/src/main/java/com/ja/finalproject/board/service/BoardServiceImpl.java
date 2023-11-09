package com.ja.finalproject.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.board.mapper.BoardSqlMapper;
import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.user.mapper.UserSqlMapper;

@Service
public class BoardServiceImpl {

	@Autowired
	private BoardSqlMapper boardSqlMapper; 
	@Autowired
	private UserSqlMapper userSqlMapper; 
	
	public void writeArticle(FreeboardArticleDto freeboardArticleDto) {
		boardSqlMapper.insert(freeboardArticleDto);
	}
	
	public List<Map<String,Object>> getArticleList() {
		
		List<Map<String,Object>> list = new ArrayList<>();
		
		List<FreeboardArticleDto> articleDtolist = 
				boardSqlMapper.selectAll();
		
		for(FreeboardArticleDto freeboardArticleDto : articleDtolist) {
			int userPk = freeboardArticleDto.getUser_id();
			UserDto userDto = userSqlMapper.selectById(userPk);
			
			Map<String, Object> map = new HashMap<>();
			map.put("freeboardArticleDto", freeboardArticleDto);
			map.put("userDto", userDto);
			
			list.add(map);
		}
		
		return list;
	}
	
	public Map<String, Object> getArticle(int articleId){
		
		Map<String, Object> map = new HashMap<>();
		
		FreeboardArticleDto articleDto = boardSqlMapper.selectById(articleId);
		int userPk = articleDto.getUser_id();
		UserDto userDto = userSqlMapper.selectById(userPk);
		
		map.put("freeboardArticleDto", articleDto);
		map.put("userDto", userDto);
		
		return map;
		
	}
	
	public void increaseReadCount(int articleId) {
		boardSqlMapper.increaseReadCount(articleId);
	}
	
	public void deleteArticle(int articleId) {
		boardSqlMapper.delete(articleId);
	}
	
	public void updateArticle(FreeboardArticleDto freeboardArticleDto) {
		boardSqlMapper.update(freeboardArticleDto);
	}
	
}















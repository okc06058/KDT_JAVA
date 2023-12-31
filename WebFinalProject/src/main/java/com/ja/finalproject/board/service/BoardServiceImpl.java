package com.ja.finalproject.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.admin.mapper.AdminSqlMapper;
import com.ja.finalproject.dto.AdminDto;
import com.ja.finalproject.dto.ArticleImageDto;
import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserAdressDto;
import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.user.mapper.UserSqlMapper;

@Service
public class BoardServiceImpl {

	@Autowired
	private AdminSqlMapper adminSqlMapper; 
	@Autowired
	private UserSqlMapper userSqlMapper; 
	
	public void writeArticle(FreeboardArticleDto freeboardArticleDto, List<ArticleImageDto> articleImageDtoList) {
		int articlePk = adminSqlMapper.createArticlePk();

		freeboardArticleDto.setId(articlePk);
		adminSqlMapper.insertshop(freeboardArticleDto);
		System.out.println();
		for(ArticleImageDto articleImageDto : articleImageDtoList) {
			articleImageDto.setArticle_id(articlePk);
			adminSqlMapper.insertImage(articleImageDto);
		}
		
		adminSqlMapper.insertshop(freeboardArticleDto);
	}
	
	public List<Map<String,Object>> getArticleList() {
		
		List<Map<String,Object>> list = new ArrayList<>();
		
		List<FreeboardArticleDto> articleDtolist = 
				adminSqlMapper.selectAll();
		
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
		
		FreeboardArticleDto articleDto = adminSqlMapper.selectshopById(articleId);
		int userPk = articleDto.getUser_id();
		AdminDto adminDto = adminSqlMapper.selectById(userPk);
		UserDto userDto = userSqlMapper.selectById(articleId);
		
		
		map.put("freeboardArticleDto", articleDto);
		map.put("adminDto", adminDto);
		map.put("userDto", userDto);
	//	map.put("articleImageDtoList", articleImageDtoList);
		//map.put("AdminDto", adminDto);
		
		return map;
		
	}
	

	public void decreaseTotalCount(int articleId) {
		adminSqlMapper.decreaseTotalCount(articleId);
	}
	
	public void deleteArticle(int articleId) {
		adminSqlMapper.delete(articleId);
	}
	
	public void updateArticle(FreeboardArticleDto freeboardArticleDto) {
		adminSqlMapper.update(freeboardArticleDto);
	}

	

	
	
	
}















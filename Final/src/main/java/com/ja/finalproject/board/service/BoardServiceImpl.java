package com.ja.finalproject.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.board.mapper.BoardSqlMapper;
import com.ja.finalproject.dto.ArticleImageDto;
import com.ja.finalproject.dto.CommentDto;
import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.user.mapper.UserSqlMapper;

@Service
public class BoardServiceImpl {

	@Autowired
	private BoardSqlMapper boardSqlMapper; 
	@Autowired
	private UserSqlMapper userSqlMapper; 
	
	public void writeArticle(FreeboardArticleDto freeboardArticleDto, List<ArticleImageDto> articleImageDtoList) {
		
		int articlePk = boardSqlMapper.createArticlePk();

		freeboardArticleDto.setId(articlePk);
		boardSqlMapper.insert(freeboardArticleDto);
		
		for(ArticleImageDto articleImageDto : articleImageDtoList) {
			articleImageDto.setArticle_id(articlePk);
			boardSqlMapper.insertImage(articleImageDto);
		}
	}
	
	public List<Map<String,Object>> getArticleList(int pageNum, String searchType, String searchWord) {
		
		List<Map<String,Object>> list = new ArrayList<>();
		
		List<FreeboardArticleDto> articleDtolist = 
				boardSqlMapper.selectAll(pageNum, searchType, searchWord);
		
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
	
	public int getArticleTotalCount(String searchType, String searchWord) {
		return boardSqlMapper.count(searchType, searchWord);
	}
	
	public Map<String, Object> getArticle(int articleId){
		
		Map<String, Object> map = new HashMap<>();
		
		FreeboardArticleDto articleDto = boardSqlMapper.selectById(articleId);
		int userPk = articleDto.getUser_id();
		UserDto userDto = userSqlMapper.selectById(userPk);
		
		List<ArticleImageDto> articleImageDtoList = 
				boardSqlMapper.getArticleImageListByArticleId(articleId);
		
		// html escape
		String content = articleDto.getContent();
		content = StringEscapeUtils.escapeHtml4(content);
		content = content.replaceAll("\n", "<br>");
		articleDto.setContent(content);
		
		
		map.put("freeboardArticleDto", articleDto);
		map.put("userDto", userDto);
		map.put("articleImageDtoList", articleImageDtoList);
		
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
	// 댓글
	public void writeComment(CommentDto commentDto) {
		boardSqlMapper.insertComment(commentDto);
	}
	
	public void updateComment(CommentDto commentDto) {
		boardSqlMapper.updateComment(commentDto);
	}
	
	public void deleteComment(int commentId) {
		boardSqlMapper.deleteCommentById(commentId);
	}
	
	public List<Map<String, Object>> getCommentList(int articleId){
		List<Map<String, Object>> mapList = new ArrayList<>();
		
		List<CommentDto> commentDtoList = 
				boardSqlMapper.selectCommentListByArticleId(articleId);
		
		for(CommentDto commentDto : commentDtoList) {
			UserDto userDto = userSqlMapper.selectById(commentDto.getUser_id());
			
			Map<String, Object> map = new HashMap<>();
			map.put("commentDto", commentDto);
			map.put("userDto", userDto);
			mapList.add(map);
		}		
		
		return mapList;
	}
}














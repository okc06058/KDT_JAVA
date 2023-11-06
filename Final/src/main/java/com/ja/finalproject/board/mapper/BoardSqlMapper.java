package com.ja.finalproject.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ja.finalproject.dto.ArticleImageDto;
import com.ja.finalproject.dto.CommentDto;
import com.ja.finalproject.dto.FreeboardArticleDto;

public interface BoardSqlMapper {

	public int createArticlePk();
	
	public void insert(FreeboardArticleDto ouiefhiwfh);
	
	public List<FreeboardArticleDto> selectAll(
			@Param("pageNum") int pageNum, 
			@Param("searchType") String searchType, 
			@Param("searchWord") String searchWord
		);
	
	public int count(
			@Param("searchType") String searchType, 
			@Param("searchWord") String searchWord
		);
	
	public FreeboardArticleDto selectById(int id);
	public void increaseReadCount(int id);

	public void delete(int id);
	
	public void update(FreeboardArticleDto freeboardArticleDto);
	
	// 이미지 관련
	public void insertImage(ArticleImageDto articleImageDto);
	public List<ArticleImageDto> getArticleImageListByArticleId(int article_id);
	
	// 댓글
	public void insertComment(CommentDto commentDto);
	public List<CommentDto> selectCommentListByArticleId(int article_id);
	public void deleteCommentById(int id);
	public void updateComment(CommentDto commentDto);
		
}




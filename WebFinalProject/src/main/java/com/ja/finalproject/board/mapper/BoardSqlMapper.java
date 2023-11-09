package com.ja.finalproject.board.mapper;

import java.util.List;

import com.ja.finalproject.dto.FreeboardArticleDto;

public interface BoardSqlMapper {

	public void insert(FreeboardArticleDto ouiefhiwfh);
	
	public List<FreeboardArticleDto> selectAll();
	
	public FreeboardArticleDto selectById(int id);
	public void increaseReadCount(int id);

	public void delete(int id);
	
	public void update(FreeboardArticleDto freeboardArticleDto);
	
	
}




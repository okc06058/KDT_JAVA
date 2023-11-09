package com.ja.finalproject.admin.mapper;

import java.util.List;

import com.ja.finalproject.dto.AdminDto;
import com.ja.finalproject.dto.FreeboardArticleDto;

public interface AdminSqlMapper {
	public void insert(AdminDto adminDto);

	public AdminDto selectByAdminIdAndPassword(AdminDto adminDto);

	public AdminDto selectById(int id);
	
	public void insertshop(FreeboardArticleDto ouiefhiwfh);
	
	public List<FreeboardArticleDto> selectAll();
	
	public FreeboardArticleDto selectshopById(int id);
	public void increaseReadCount(int id);

	public void delete(int id);
	
	public void update(FreeboardArticleDto freeboardArticleDto);
}

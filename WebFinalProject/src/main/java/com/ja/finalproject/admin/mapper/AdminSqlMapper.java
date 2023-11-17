package com.ja.finalproject.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ja.finalproject.dto.AdminDto;
import com.ja.finalproject.dto.ArticleImageDto;
import com.ja.finalproject.dto.CategoryDto;
import com.ja.finalproject.dto.FreeboardArticleDto;


public interface AdminSqlMapper {
	
	//관리자
	public void insert(AdminDto adminDto);
	public AdminDto selectByAdminIdAndPassword(AdminDto adminDto);
	public AdminDto selectById(int id);
	
	
	//상품
	public void insertshop(FreeboardArticleDto ouiefhiwfh);	
	public List<FreeboardArticleDto> selectAll();
	public FreeboardArticleDto selectshopById(int id);
	public void decreaseTotalCount(int id);
	public void delete(int id);
	public void update(FreeboardArticleDto freeboardArticleDto);
	
	//샵으로 상품 검색
	public List<FreeboardArticleDto> selectShopListAll(int id);
	
	// 카테고리 관련
	public List<CategoryDto> selectCategoryAll();

	//이미지 관련
	public void insertImage(ArticleImageDto articleImageDto);
	public List<ArticleImageDto> getArticleImageListByArticleId(int article_id);
	
	public int createArticlePk();
	
	public void insertByFree(FreeboardArticleDto ouiefhiwfh);
	public int count(String searchType, String searchWord);

	
	
	

}	

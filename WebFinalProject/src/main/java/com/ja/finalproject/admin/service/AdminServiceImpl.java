
package com.ja.finalproject.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.admin.mapper.AdminSqlMapper;
import com.ja.finalproject.dto.AdminDto;
import com.ja.finalproject.dto.ArticleImageDto;
import com.ja.finalproject.dto.CategoryDto;
import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserDto;

@Service
public class AdminServiceImpl {

	@Autowired
	private AdminSqlMapper adminSqlMapper;


	public void register(AdminDto adminDto) {
		adminSqlMapper.insert(adminDto);
	}

	public AdminDto getUserInfoByUserIdAndPassword(AdminDto adminDto) {

		AdminDto result = adminSqlMapper.selectByAdminIdAndPassword(adminDto);
		return result;
	}

	public void writeArticle(FreeboardArticleDto freeboardArticleDto) {
		adminSqlMapper.insertshop(freeboardArticleDto);
	}

	// 카테고리
	public List<CategoryDto> getCategoryList() {
		return adminSqlMapper.selectCategoryAll();
	}

	// 샵 등록리스트 검색
	public List<FreeboardArticleDto> getShopList(int id) {
		return adminSqlMapper.selectShopListAll(id);
	}

	// 이미지 처리
		public void writeArticle(FreeboardArticleDto freeboardArticleDto, List<ArticleImageDto> articleImageDtoList) {

			int articlePk = adminSqlMapper.createArticlePk();
			System.out.println(articlePk);			
			freeboardArticleDto.setId(articlePk);
			adminSqlMapper.insertshop(freeboardArticleDto);

			for (ArticleImageDto articleImageDto : articleImageDtoList) {
				articleImageDto.setArticle_id(articlePk);
				adminSqlMapper.insertImage(articleImageDto);
			}
		}

	public List<Map<String, Object>> getArticleList(int pageNum, String searchType, String searchWord) {

		List<Map<String, Object>> list = new ArrayList<>();

		List<FreeboardArticleDto> articleDtolist = adminSqlMapper.selectAll();

		for (FreeboardArticleDto freeboardArticleDto : articleDtolist) {
			int userPk = freeboardArticleDto.getId();
			FreeboardArticleDto userDto = adminSqlMapper.selectshopById(userPk);

			Map<String, Object> map = new HashMap<>();
			map.put("freeboardArticleDto", freeboardArticleDto);
			map.put("userDto", userDto);

			list.add(map);
		}

		return list;
	}

	public int getArticleTotalCount(String searchType, String searchWord) {
		return adminSqlMapper.count(searchType, searchWord);
	}

	public List<Map<String, Object>> getArticle(int id){
		List<Map<String, Object>> mapList = new ArrayList<>();
		
	//	int id = params.getUser_id();
		List<FreeboardArticleDto> freeboardArticleDtoList = 
				adminSqlMapper.selectShopListAll(id);
		
		for(FreeboardArticleDto pa : freeboardArticleDtoList) {
			FreeboardArticleDto freeboardArticleDto = adminSqlMapper.selectshopById(pa.getId());
			
			Map<String, Object> map = new HashMap<>();
			map.put("freeboardArticleDto", freeboardArticleDto);
			//map.put("adminDto", adminDto);
			mapList.add(map);
		}		
		
		return mapList;
	}

	
	
}

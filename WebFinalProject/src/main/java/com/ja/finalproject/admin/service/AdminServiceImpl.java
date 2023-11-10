
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

		freeboardArticleDto.setId(articlePk);
		adminSqlMapper.insert(freeboardArticleDto);

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

	public Map<String, Object> getArticle(int articleId) {

		Map<String, Object> map = new HashMap<>();

		FreeboardArticleDto articleDto = adminSqlMapper.selectshopById(articleId);
		int userPk = articleDto.getId();
		FreeboardArticleDto adminDto = adminSqlMapper.selectshopById(userPk);

		List<ArticleImageDto> articleImageDtoList = adminSqlMapper.getArticleImageListByArticleId(articleId);

		// html escape
		String content = articleDto.getContent();
		content = StringEscapeUtils.escapeHtml4(content);
		content = content.replaceAll("\n", "<br>");
		articleDto.setContent(content);

		map.put("freeboardArticleDto", articleDto);
		map.put("adminDto", adminDto);
		map.put("articleImageDtoList", articleImageDtoList);

		return map;

	}
}

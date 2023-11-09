
package com.ja.finalproject.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.admin.mapper.AdminSqlMapper;
import com.ja.finalproject.dto.AdminDto;
import com.ja.finalproject.dto.FreeboardArticleDto;

@Service
public class AdminServiceImpl {

	
	@Autowired
	private AdminSqlMapper adminSqlMapper;
	
	public void register(AdminDto adminDto) {
		adminSqlMapper.insert(adminDto);
	}
	
	public AdminDto getUserInfoByUserIdAndPassword(AdminDto adminDto){
		
		AdminDto result = adminSqlMapper.selectByAdminIdAndPassword(adminDto);
		return result; 
	}

	public void writeArticle(FreeboardArticleDto freeboardArticleDto) {
		adminSqlMapper.insertshop(freeboardArticleDto);
		
	}
}

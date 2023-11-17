package com.ja.finalproject.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.admin.mapper.AdminSqlMapper;
import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserAdressDto;
import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.user.mapper.UserSqlMapper;

@Service
public class UserServiceImpl{
	
	@Autowired
	private UserSqlMapper userSqlMapper;
	@Autowired
	private AdminSqlMapper adminSqlMapper;
	
	public void register(UserDto userDto) {
		userSqlMapper.insert(userDto);
	}
	
	public UserDto getUserInfoByUserIdAndPassword(UserDto userDto){
		
		UserDto result = userSqlMapper.selectByUserIdAndPassword(userDto);
		return result; 
	}
	

	public void registerAdress(UserAdressDto userAdressDto) {
		userSqlMapper.insertAdress(userAdressDto);
	}
	
	// 사용자 주소 검색
	public List<UserAdressDto> getSelectAdressId(int id) {
		return userSqlMapper.selectAdressId(id);
	}
	
	public UserAdressDto setsessionAdressInfo(int id) {
		return userSqlMapper.sessionAdressInfo(id);
	}

	
	
	//샵 전체 리스트
	public List<FreeboardArticleDto> getUserShop() {

		return adminSqlMapper.selectAll();
	}
	
	//배송지 리스트 삭제

	public void deleteAdressID(int id) {
		userSqlMapper.deleteAdressId(id);
	}
}



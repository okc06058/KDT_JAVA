package com.ja.finalproject.user.mapper;

import java.util.List;

import com.ja.finalproject.dto.HobbyCategoryDto;
import com.ja.finalproject.dto.MailAuthenticationDto;
import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.dto.UserHobbyDto;

public interface UserSqlMapper {
	// Mybatis 활용시 리턴 타입: insert, update, delete = void | int
	// Mybatis 활용시 리턴 타입: select = 꼭 지정해야됨
	
	public int createUserPk();
	
	public void insert(UserDto userDto);
	public UserDto selectByUserId(UserDto userDto);
	public UserDto selectById(int id); 

	// 취미 카테고리 관련
	public List<HobbyCategoryDto> selectHobbyCategoryAll();
	public void insertUserHobby(UserHobbyDto userHobbyDto);

	// 메일 인증 관련
	public void insertMailAuthentication(MailAuthenticationDto mailAuthenticationDto);
	public void updateMailAuthenticationByKey(String auth_key);
	

	//아이디 존재 확인
	public int countByUserId(String userid);
	
	
}










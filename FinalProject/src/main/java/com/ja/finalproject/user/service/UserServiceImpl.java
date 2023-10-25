package com.ja.finalproject.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.user.mapper.UserSqlMapper;

@Service
public class UserServiceImpl {
	 // Impl => implements 약자
		
	@Autowired
	private UserSqlMapper userSqlMapper;
	   
	   public void register(UserDto userDto) {
	      //.. 하고 싶은 로직..!
	      // 비즈니스 layer
	      // 결과적으로 데이터베이스 연동해서 insert하는 코드
		   //데이터 베이스에 입력
		   userSqlMapper.insert(userDto);
	   }
	   
	   public UserDto getUserInfoByIdAndPassword(UserDto userDto) {
		   UserDto result = userSqlMapper.selectByUserIdAndPassword(userDto);
		   return result;
	   }
}

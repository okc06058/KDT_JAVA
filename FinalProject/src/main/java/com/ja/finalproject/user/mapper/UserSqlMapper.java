package com.ja.finalproject.user.mapper;

import com.ja.finalproject.dto.UserDto;

public interface UserSqlMapper {
	
	public void insert(UserDto userDto);

	public UserDto selectByUserIdAndPassword(UserDto userDto);
	
	public UserDto selectById(int id);
}

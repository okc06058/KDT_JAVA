package com.ja.finalproject.user.mapper;

import java.util.List;

import com.ja.finalproject.dto.FreeboardArticleDto;
import com.ja.finalproject.dto.UserAdressDto;
import com.ja.finalproject.dto.UserDto;

public interface UserSqlMapper {
	public void insert(UserDto userDto);
	
	public UserDto selectByUserIdAndPassword(UserDto userDto);
	
	public UserDto selectById(int id); 
	
	//배송지
	public void insertAdress(UserAdressDto userAdressDto);
	public List<UserAdressDto> selectAdressId(int id);
	public void deleteAdressId(int id);
	//public FreeboardArticleDto selectShopAll();
	
}

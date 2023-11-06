package com.ja.finalproject.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ja.finalproject.dto.RestResponseDto;
import com.ja.finalproject.dto.UserDto;
import com.ja.finalproject.user.service.UserServiceImpl;

@RestController // @ResponseBody + @Controller
@RequestMapping("/user/*")
public class RestUserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("existByUserId")
	public RestResponseDto existByUserId(String userid) {
		
		RestResponseDto restResponseDto = new RestResponseDto();
		
		restResponseDto.setResult("success");
		restResponseDto.setData(userService.existUserId(userid));
		
		return restResponseDto;
		
	}
	
	@RequestMapping("getMyId")
	public RestResponseDto getMyId(HttpSession session) {
		RestResponseDto restResponseDto = new RestResponseDto();
		
		UserDto sessionUser = (UserDto)session.getAttribute("sessionUserInfo");
		
		restResponseDto.setResult("success");
		
		if(sessionUser != null) {
			restResponseDto.setData(sessionUser.getId());
		}
		
		return restResponseDto;
	}
	
}






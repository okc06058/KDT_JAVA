package com.ja.finalproject.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserDto {
	private int id;
	private String userid;
	private String password;
	private String nickname;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	
	public UserDto() {
		super();
	}

	public UserDto(int id, String userid, String password, String nickname, String gender, Date created_at) {
		super();
		this.id = id;
		this.userid = userid;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}







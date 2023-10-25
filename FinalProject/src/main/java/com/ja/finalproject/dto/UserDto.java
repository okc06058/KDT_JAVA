package com.ja.finalproject.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserDto {
	private int id;
	private String userid;
	private String password;
	private String nickname;
	private String email;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")// input type="data"가 날라 오는 경우 무조건 얘 붙여야 함
	private Date birth;
	private String phone;
	private Date created_at;

	public UserDto() {
		super();
	}
	
	public UserDto(int id, String userid, String password, String nickname, String email, String gender, Date birth,
			String phone, Date created_at) {
		super();
		this.id = id;
		this.userid = userid;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.gender = gender;
		this.birth = birth;
		this.phone = phone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

}

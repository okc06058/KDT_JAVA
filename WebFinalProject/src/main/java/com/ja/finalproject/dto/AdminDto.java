package com.ja.finalproject.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AdminDto {
	private int id;
	private String userid;
	private String password;
	private String shopname;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	public AdminDto() {
		super();
	}
	public AdminDto(int id, String userid, String password, String shopname, Date created_at) {
		super();
		this.id = id;
		this.userid = userid;
		this.password = password;
		this.shopname = shopname;
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
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

}

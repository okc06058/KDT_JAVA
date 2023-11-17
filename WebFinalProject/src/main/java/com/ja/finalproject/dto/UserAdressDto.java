
package com.ja.finalproject.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserAdressDto {
	private int id;
	private int user_id;
	private String adress_name;
	private String adress;
	private String phone_number;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created_at;
	public UserAdressDto() {
		super();
	}
	public UserAdressDto(int id, int user_id, String adress_name, String adress, String phone_number, Date created_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.adress_name = adress_name;
		this.adress = adress;
		this.phone_number = phone_number;
		this.created_at = created_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAdress_name() {
		return adress_name;
	}
	public void setAdress_name(String adress_name) {
		this.adress_name = adress_name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}

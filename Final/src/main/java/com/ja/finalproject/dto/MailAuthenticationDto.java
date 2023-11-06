package com.ja.finalproject.dto;

import java.util.Date;

public class MailAuthenticationDto {

	private int id;
	private int user_id;
	private String auth_key;
	private String complete;
	private Date complete_date;
	private Date created_at;
	
	public MailAuthenticationDto() {
		super();
	}
	
	public MailAuthenticationDto(int id, int user_id, String auth_key, String complete, Date complete_date,
			Date created_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.auth_key = auth_key;
		this.complete = complete;
		this.complete_date = complete_date;
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
	public String getAuth_key() {
		return auth_key;
	}
	public void setAuth_key(String auth_key) {
		this.auth_key = auth_key;
	}
	public String getComplete() {
		return complete;
	}
	public void setComplete(String complete) {
		this.complete = complete;
	}
	public Date getComplete_date() {
		return complete_date;
	}
	public void setComplete_date(Date complete_date) {
		this.complete_date = complete_date;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	
}







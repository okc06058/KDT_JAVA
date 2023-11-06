package com.ja.finalproject.dto;

public class UserHobbyDto {
	private int id;
	private int user_id;
	private int hobby_id;
	public UserHobbyDto() {
		super();
	}
	public UserHobbyDto(int id, int user_id, int hobby_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.hobby_id = hobby_id;
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
	public int getHobby_id() {
		return hobby_id;
	}
	public void setHobby_id(int hobby_id) {
		this.hobby_id = hobby_id;
	}
	
	
}

package com.ja.finalproject.dto;

import java.util.Date;

public class FreeboardArticleDto {
	private int id;
	private int user_id;
	private String title;
	private String content;
	private int read_count;
	private Date created_at;
	
	
	public FreeboardArticleDto() {
		super();
	}


	public FreeboardArticleDto(int id, int user_id, String title, String content, int read_count, Date created_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.read_count = read_count;
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


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getRead_count() {
		return read_count;
	}


	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}


	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	
	
}

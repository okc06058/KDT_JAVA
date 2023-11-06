package com.ja.finalproject.dto;

import java.util.Date;

public class CommentDto {
	private int id;
	private int article_id;
	private int user_id;
	private String text;
	private Date created_at;
	
	public CommentDto() {
		super();
	}
	
	public CommentDto(int id, int article_id, int user_id, String text, Date created_at) {
		super();
		this.id = id;
		this.article_id = article_id;
		this.user_id = user_id;
		this.text = text;
		this.created_at = created_at;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	
	
	
}

package com.ja.finalproject.dto;

import java.util.Date;

public class ArticleImageDto {
	private int id;
	private int article_id;
	private String location;
	private String original_filename;
	private Date created_at;
	
	public ArticleImageDto() {
		super();
	}
	
	public ArticleImageDto(int id, int article_id, String location, String original_filename, Date created_at) {
		super();
		this.id = id;
		this.article_id = article_id;
		this.location = location;
		this.original_filename = original_filename;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOriginal_filename() {
		return original_filename;
	}
	public void setOriginal_filename(String original_filename) {
		this.original_filename = original_filename;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	
	
}

package com.ja.finalproject.dto;

import java.util.Date;

public class FreeboardArticleDto {

	private int id;
	private int categori;
	private int user_id;
	private String titlename;
	private String content;
	private int price;
	private int total_count;
	private Date created_at;
	
	public FreeboardArticleDto() {
		super();
	}

	public FreeboardArticleDto(int id, int categori, int user_id, String titlename, String content, int price,
			int total_count, Date created_at) {
		super();
		this.id = id;
		this.categori = categori;
		this.user_id = user_id;
		this.titlename = titlename;
		this.content = content;
		this.price = price;
		this.total_count = total_count;
		this.created_at = created_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategori() {
		return categori;
	}

	public void setCategori(int categori) {
		this.categori = categori;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitlename() {
		return titlename;
	}

	public void setTitlename(String titlename) {
		this.titlename = titlename;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	
	
}

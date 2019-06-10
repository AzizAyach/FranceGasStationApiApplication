package com.ayach.francestation.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection="services")
public class Services {

	@Id
	private String name ;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdAt;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date updatedAt;
	
	public Services(){
		
	}
	
	public Services(String name, Date createdAt, Date updatedAt) {
		super();
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	

}

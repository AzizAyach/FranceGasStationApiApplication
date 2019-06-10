package com.ayach.francestation.entity;



import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Document(collection="unavailability")
public class Unavaibility {

	private String id;
	private String type;
	private Date dateOfStart;
	private Date dateOfEnd ;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdAt;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date updatedAt;
	
	public Unavaibility(){
		
	}
	
	public Unavaibility(String id, String type, Date dateOfStart,
			Date dateOfEnd, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.type = type;
		this.dateOfStart = dateOfStart;
		this.dateOfEnd = dateOfEnd;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDateOfStart() {
		return dateOfStart;
	}
	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}
	public Date getDateOfEnd() {
		return dateOfEnd;
	}
	public void setDateOfEnd(Date dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
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
package com.ayach.francestation.entity;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection="fuelOut") 
public class FuelOut {
	
	@Id
	private int code ;
	private String name;    
	private Date dateOfStart ;
	private Date dateOfEnd ;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdAt;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date updatedAt;
	
	
	public FuelOut(int code, String name, Date dateOfStart,
			Date dateOfEnd, Date createdAt, Date updatedAt) {
		super();
		this.code = code;
		this.name = name;
		this.dateOfStart = dateOfStart;
		this.dateOfEnd = dateOfEnd;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public FuelOut() {
		
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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

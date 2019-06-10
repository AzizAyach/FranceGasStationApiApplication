package com.ayach.francestation.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "prices")
public class Price {
	@Id
	private int code;
	private String name;
	private Double priceValue;
	private Date dateOfupdate;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdAt;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date updatedAt;

	public Price() {

	}

	public Price(String id, int code, String name, Double priceValue, Date dateOfupdate, Date createdAt,
			Date updatedAt) {
		super();
		this.code = code;
		this.name = name;
		this.priceValue = priceValue;
		this.dateOfupdate = dateOfupdate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public Double getPriceValue() {
		return priceValue;
	}

	public void setPriceValue(Double priceValue) {
		this.priceValue = priceValue;
	}

	public Date getDateOfupdate() {
		return dateOfupdate;
	}

	public void setDateOfupdate(Date dateOfupdate) {
		this.dateOfupdate = dateOfupdate;
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

package com.ayach.francestation.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "historicalPrice")
public class PriceHistorical {

	@Id
	private String id;
	private int code;
	private String name;
	private Double price;
	private Date dateOfupdate;
	private Long codeStation ;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdAt;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date updatedAt;

	public PriceHistorical(String id, int code,Long codeStation, String name, Double price,
				Date dateOfupdate, Date createdAt, Date updatedAt) {
			super();
			this.id = id;
			this.code = code;
			this.name = name;
			this.price = price;
			this.dateOfupdate = dateOfupdate;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.codeStation=codeStation;
		}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public Long getCodeStation() {
		return codeStation;
	}

	public void setCodeStation(Long codeStation) {
		this.codeStation = codeStation;
	}
	

}

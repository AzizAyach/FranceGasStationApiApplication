package com.ayach.francestation.entity;



import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.ayach.francestation.xml.entity.Jour;

@Document(collection="avaibility") 
public class Avaibility {


private	boolean automate24 ;

private List <Jour> jour;

@DateTimeFormat(iso = ISO.DATE_TIME)
private Date createdAt;
@DateTimeFormat(iso = ISO.DATE_TIME)
private Date updatedAt;



public Avaibility(){
	
}



public Avaibility(boolean automate24, List<Jour> jour, Date createdAt, Date updatedAt) {
	super();
	this.automate24 = automate24;
	this.jour = jour;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
}



public boolean isAutomate24() {
	return automate24;
}



public void setAutomate24(boolean automate24) {
	this.automate24 = automate24;
}



public List<Jour> getJour() {
	return jour;
}



public void setJour(List<Jour> jour) {
	this.jour = jour;
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

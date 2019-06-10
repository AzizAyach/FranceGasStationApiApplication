package com.ayach.francestation.xml.entity;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class Services {

	private List<String> service;
	
	public Services(){
		
	}

	public Services(List<String> service) {
		super();
		this.service = service;
	}

	public List<String> getService() {
		return service;
	}

	public void setService(List<String> service) {
		this.service = service;
	}	

	
	
	
	
}

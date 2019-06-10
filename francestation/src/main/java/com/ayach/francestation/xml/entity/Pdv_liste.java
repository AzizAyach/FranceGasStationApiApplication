package com.ayach.francestation.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="pdv_liste")
@XmlAccessorType(XmlAccessType.FIELD)
public class Pdv_liste {

@XmlElement 
private List<Pdv> pdv;


public Pdv_liste(){
	
}

public Pdv_liste(List<Pdv> pdv) {
	super();
	this.pdv = pdv;
}



public List<Pdv> getPdv() {
	return pdv;
}

public void setPdv(List<Pdv> pdv) {
	this.pdv = pdv;
}
	
}



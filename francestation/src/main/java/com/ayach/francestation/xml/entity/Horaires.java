package com.ayach.francestation.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@XmlAccessorType(XmlAccessType.FIELD)
public class Horaires {
	
	   @XmlAttribute(name="automate-24-24")
	    private String automate;

	    private List <Jour> jour;
         
		public String getAutomate() {
			return automate; 
		}

		public void setAutomate(String automate) {
			this.automate = automate;
		}

		public List<Jour> getJour() {
			return jour;
		}

		public void setJour(List<Jour> jour) {
			this.jour = jour;
		}

	 
}

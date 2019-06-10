package com.ayach.francestation.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@XmlAccessorType(XmlAccessType.FIELD)
public class Jour {

	@XmlAttribute
	private String id;
	
	@XmlAttribute
    private String ferme;

    private List<Horaire> horaire;
    
    @XmlAttribute
    private String nom;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getFerme ()
    {
        return ferme;
    }

    public void setFerme (String ferme)
    {
        this.ferme = ferme;
    }

    

    public String getNom ()
    {
        return nom;
    }

    public void setNom (String nom)
    {
        this.nom = nom;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", ferme = "+ferme+", horaire = "+horaire+", nom = "+nom+"]";
    }
}

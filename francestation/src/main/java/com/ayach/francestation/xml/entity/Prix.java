package com.ayach.francestation.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



@XmlAccessorType(XmlAccessType.FIELD)
public class Prix
{   @XmlAttribute
    private String id;
    @XmlAttribute
    private String valeur;
    @XmlAttribute
    private String maj;
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

    public String getValeur ()
    {
        return valeur;
    }

    public void setValeur (String valeur)
    {
        this.valeur = valeur;
    }

    public String getMaj ()
    {
        return maj;
    }

    public void setMaj (String maj)
    {
        this.maj = maj;
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
        return "ClassPojo [id = "+id+", valeur = "+valeur+", maj = "+maj+", nom = "+nom+"]";
    }
}

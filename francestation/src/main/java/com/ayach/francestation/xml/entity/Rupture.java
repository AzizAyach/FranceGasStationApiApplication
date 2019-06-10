package com.ayach.francestation.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



@XmlAccessorType(XmlAccessType.FIELD)
public class Rupture
{   @XmlAttribute
    private String id;
    @XmlAttribute
    private String fin;
    @XmlAttribute
    private String debut;
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

    public String getFin ()
    {
        return fin;
    }

    public void setFin (String fin)
    {
        this.fin = fin;
    }

    public String getDebut ()
    {
        return debut;
    }

    public void setDebut (String debut)
    {
        this.debut = debut;
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
        return "ClassPojo [id = "+id+", fin = "+fin+", debut = "+debut+", nom = "+nom+"]";
    }
}

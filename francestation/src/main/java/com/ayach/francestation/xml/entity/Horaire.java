package com.ayach.francestation.xml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



@XmlAccessorType(XmlAccessType.FIELD)
public class Horaire
{   @XmlAttribute
    private String fermeture;
    @XmlAttribute
    private String ouverture;

    public String getFermeture ()
    {
        return fermeture;
    }

    public void setFermeture (String fermeture)
    {
        this.fermeture = fermeture;
    }

    public String getOuverture ()
    {
        return ouverture;
    }

    public void setOuverture (String ouverture)
    {
        this.ouverture = ouverture;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [fermeture = "+fermeture+", ouverture = "+ouverture+"]";
    }
}

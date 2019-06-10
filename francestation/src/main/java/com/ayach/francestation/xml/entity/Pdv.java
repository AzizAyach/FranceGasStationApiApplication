package com.ayach.francestation.xml.entity;



import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;



@XmlAccessorType(XmlAccessType.FIELD)
public class Pdv {
	
	@XmlAttribute
	private String id;

    private Services services;

    @XmlAttribute
    private String cp;
 
    private String adresse;

    private List<Prix> prix;

    private String ville;
    
    @XmlAttribute
    private String longitude;

    @XmlAttribute
    private String pop;

    @XmlAttribute
    private String latitude;
    
    private List<Rupture> rupture;
    
    private Horaires horaires;
	
	
    public Horaires getHoraires() {
		return horaires;
	}

	public void setHoraires(Horaires horaires) {
		this.horaires = horaires;
	}

	public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public Services getServices ()
    {
        return services;
    }

    public void setServices (Services services)
    {
        this.services = services;
    }

    public String getCp ()
    {
        return cp;
    }

    public void setCp (String cp)
    {
        this.cp = cp;
    }

    public String getAdresse ()
    {
        return adresse;
    }

    public void setAdresse (String adresse)
    {
        this.adresse = adresse;
    }


    public String getVille ()
    {
        return ville;
    }

    public void setVille (String ville)
    {
        this.ville = ville;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getPop ()
    {
        return pop;
    }

    public void setPop (String pop)
    {
        this.pop = pop;
    }


    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

	public List<Prix> getPrix() {
		return prix;
	}

	public void setPrix(List<Prix> prix) {
		this.prix = prix;
	}
	
    
	public List<Rupture> getRupture() {
		return rupture;
	}

	public void setRupture(List<Rupture> rupture) {
		this.rupture = rupture;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", services = "+services+", cp = "+cp+", adresse = "+adresse+", prix = "+prix+", ville = "+ville+", longitude = "+longitude+", pop = "+pop+", latitude = "+latitude+"]";
    }   
    
}

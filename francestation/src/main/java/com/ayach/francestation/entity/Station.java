package com.ayach.francestation.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Document(collection = "stations")
public class Station implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1948390532938245449L;

	@Id
	private Long code;

	private String adresse;

	private Double lattitude;

	private Double longitude;

	private String ville;

	private Long postal;

	private String entreprise;

	private String name;

	private String position;

	@GeoSpatialIndexed
	private double[] geo;

	private List<Services> services;

	private List<Price> prices;

	private List<FuelOut> fuelOuts;

	private Avaibility avaibility;

	private Unavaibility unavailability;

	public Station() {

	}

	public Station(Long code, String adresse, Double lattitude, Double longitude, String ville, Long postal,
			String entreprise, String name, String position, Double[] geo, List<Services> services, List<Price> prices,
			List<FuelOut> fuelOuts, Avaibility avaibility, Unavaibility unavailability) {
		super();
		this.code = code;
		this.adresse = adresse;
		this.lattitude = lattitude;
		this.longitude = longitude;
		this.ville = ville;
		this.postal = postal;
		this.entreprise = entreprise;
		this.name = name;
		this.position = position;
		this.geo = new double[] {lattitude,longitude };
		this.services = services;
		this.prices = prices;
		this.fuelOuts = fuelOuts;
		this.avaibility = avaibility;
		this.unavailability = unavailability;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Long getPostal() {
		return postal;
	}

	public void setPostal(Long postal) {
		this.postal = postal;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double[] getGeo() {
		return geo;
	}

	public void setGeo(double[] geo) {
		this.geo = geo;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public List<FuelOut> getFuelOuts() {
		return fuelOuts;
	}

	public void setFuelOuts(List<FuelOut> fuelOuts) {
		this.fuelOuts = fuelOuts;
	}

	public Avaibility getAvaibility() {
		return avaibility;
	}

	public void setAvaibility(Avaibility avaibility) {
		this.avaibility = avaibility;
	}

	public Unavaibility getUnavailability() {
		return unavailability;
	}

	public void setUnavailability(Unavaibility unavailability) {
		this.unavailability = unavailability;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}

}
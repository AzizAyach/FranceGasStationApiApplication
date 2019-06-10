package com.ayach.francestation.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.ayach.francesstation.utility.Utility;
import com.ayach.francestation.entity.Avaibility;
import com.ayach.francestation.entity.FuelOut;
import com.ayach.francestation.entity.Price;
import com.ayach.francestation.entity.Services;
import com.ayach.francestation.entity.Station;
import com.ayach.francestation.repositories.StationRepository;
import com.ayach.francestation.repositories.StationRepositoryCustom;
import com.ayach.francestation.xml.entity.Pdv;
import com.ayach.francestation.xml.entity.Pdv_liste;
import com.ayach.francestation.xml.entity.Prix;
import com.ayach.francestation.xml.entity.Rupture;

@Service
public class StationService {

	@Autowired
	private StationRepository stationRepository;
	@Autowired
	private StationRepositoryCustom stationRepositoryCustom;

	private static final Logger logger = LoggerFactory.getLogger(StationService.class);

	public void insertAndUpdateStation(Pdv_liste pdv_liste) {
		if (pdv_liste != null && pdv_liste.getPdv() != null && !pdv_liste.getPdv().isEmpty()) {
			Long startTime = Calendar.getInstance().getTimeInMillis();
			for (Pdv pdv : pdv_liste.getPdv()) {
				Optional<Station> stationOpt = stationRepository.findById(Long.parseLong(pdv.getId()));
				try {
					if (stationOpt != null && stationOpt.isPresent()) {
						convertValueToUpdateStation(pdv, stationOpt.get(), Boolean.FALSE);
						stationRepositoryCustom.updateStation(stationOpt.get());
					} else {
						Station station = convertValueToNewStation(pdv, Boolean.TRUE);
						stationRepository.insert(station);
					}
				} catch (ParseException e) {
					logger.error(
							"Error parse station with code: " + pdv.getId() + ". Date of error: " + new Date() + " .");
				}
			}
			Long endTime = Calendar.getInstance().getTimeInMillis();
			Long result = endTime-startTime;
			logger.info("Insert and update station get time:"+ result +".ms");
		}
	}

	private Station convertValueToNewStation(Pdv pdv, boolean isNew) throws ParseException {
		if (pdv != null) {
			Station statsionentity = new Station();
			statsionentity.setCode(Long.parseLong(pdv.getId()));
			statsionentity.setAdresse(pdv.getAdresse());
			Point point = Utility.getcorrectLocation(pdv.getLatitude(), pdv.getLongitude());
			if (point != null) {
				double [] geoSp = {point.getX(),point.getY()};
				statsionentity.setGeo(geoSp);
				statsionentity.setLattitude(point.getX());
				statsionentity.setLongitude(point.getY());
			}
			statsionentity.setVille(pdv.getVille());
			statsionentity.setPostal(Long.parseLong(pdv.getCp()));
			statsionentity.setPosition(pdv.getPop());
			statsionentity.setServices(convertValueToServices(pdv, isNew));
			statsionentity.setFuelOuts(convertValueToFuelOut(pdv, isNew));
			statsionentity.setPrices(convertValueToPrice(pdv, isNew));
			statsionentity.setAvaibility(convertValueToAvaibility(pdv, isNew));
			return statsionentity;
		}

		return null;
	}

	private void convertValueToUpdateStation(Pdv pdv, Station statsionentity, boolean isNew) throws ParseException {
		if (pdv != null) {
			restValueStation(statsionentity);
			statsionentity.setServices(convertValueToServices(pdv, isNew));
			statsionentity.setFuelOuts(convertValueToFuelOut(pdv, isNew));
			statsionentity.setPrices(convertValueToPrice(pdv, isNew));
			statsionentity.setAvaibility(convertValueToAvaibility(pdv, isNew));
		}

	}

	private List<Services> convertValueToServices(Pdv pdv, boolean isNew) {
		if (pdv.getServices() != null && pdv.getServices().getService() != null
				&& !pdv.getServices().getService().isEmpty()) {
			List<Services> services = new ArrayList<>();
			for (String service : pdv.getServices().getService()) {
				Services ser = new Services();
				ser.setName(service);
				ser.setUpdatedAt(new Date());

				if (isNew)
					ser.setCreatedAt(new Date());

				services.add(ser);
			}
			return services;
		}
		return null;
	}

	private List<FuelOut> convertValueToFuelOut(Pdv pdv, boolean isNew) throws ParseException {
		if (pdv.getRupture() != null && !pdv.getRupture().isEmpty()) {
			List<FuelOut> fuelOutlist = new ArrayList<>();
			for (Rupture rupture : pdv.getRupture()) {
				FuelOut fuelOut = new FuelOut();
				fuelOut.setName(rupture.getNom());
				fuelOut.setUpdatedAt(new Date());
				fuelOut.setCode(Integer.parseInt(rupture.getId()));
				fuelOut.setDateOfStart(Utility.convertStringToDate(rupture.getDebut()));
				fuelOut.setDateOfEnd(Utility.convertStringToDate(rupture.getFin()));
				if (isNew)
					fuelOut.setCreatedAt(new Date());

				fuelOutlist.add(fuelOut);
			}
			return fuelOutlist;
		}
		return null;
	}

	private List<Price> convertValueToPrice(Pdv pdv, boolean isNew) throws ParseException {
		if (pdv.getPrix() != null && !pdv.getPrix().isEmpty()) {
			List<Price> pricelist = new ArrayList<>();
			for (Prix prix : pdv.getPrix()) {
				Price price = new Price();
				price.setName(prix.getNom());
				price.setUpdatedAt(new Date());
				price.setCode(Integer.parseInt(prix.getId()));
				price.setDateOfupdate(Utility.convertStringToDate(prix.getMaj()));
				price.setPriceValue(Double.parseDouble(prix.getValeur()));
				if (isNew)
					price.setCreatedAt(new Date());

				pricelist.add(price);
			}
			return pricelist;
		}
		return null;
	}

	private Avaibility convertValueToAvaibility(Pdv pdv, boolean isNew) {
		if (pdv.getHoraires() != null) {
			Avaibility avaibility = new Avaibility();
			avaibility.setAutomate24(pdv.getHoraires().getAutomate() != null ? true : false);
			if (pdv.getHoraires().getJour() != null && !pdv.getHoraires().getJour().isEmpty()) {
				avaibility.setJour(pdv.getHoraires().getJour());
				return avaibility;
			}
		}
		return null;
	}

	private void restValueStation(Station statsionentity) {
		statsionentity.setServices(null);
		statsionentity.setFuelOuts(null);
		statsionentity.setPrices(null);
		statsionentity.setAvaibility(null);
	}

}

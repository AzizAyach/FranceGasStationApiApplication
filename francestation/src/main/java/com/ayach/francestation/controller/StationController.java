package com.ayach.francestation.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import com.ayach.francestation.entity.Station;
import com.ayach.francestation.repositories.StationRepository;
import com.ayach.francestation.repositories.StationRepositoryCustom;

@Component
@Path("/stations")
public class StationController {

	@Autowired
	private StationRepository stationRepository;

	@Autowired
	private StationRepositoryCustom stationRepositoryCustom;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public Collection<Station> getAllStation() {

		Collection<Station> stations = stationRepository.findAll();

		return stations;

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/station")
	public Page<Station> getStationByPage(@QueryParam("page")int page) {

		return stationRepositoryCustom.getStationByPage(page - 1);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Optional<Station> getStationById(@PathParam("id") Long id) {
		return stationRepository.findById(id);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/postal/{postal}")
	public List<Station> getStationByPostal(@PathParam("postal") Long postal) {
		return stationRepository.findByPostal(postal);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/near/{lan}/{lat}/{km}")
	public Object getStatioNear(@PathParam("lan") double lon, @PathParam("lat") double lat,
			@PathParam("km") double km) {
		return stationRepository.findBygeoNear(new Point(lon, lat), new Distance(3, Metrics.KILOMETERS));

	}

}

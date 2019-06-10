package com.ayach.francestation.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import com.ayach.francesstation.utility.Constants;
import com.ayach.francestation.entity.Station;
import com.mongodb.client.result.UpdateResult;

@Repository
public class StationRepositoryCustomImpl implements StationRepositoryCustom {

	@Autowired
	MongoTemplate mongoTemplate;

	public static final Double KILOMETER = 111.0d;

	@Override
	public boolean updateStation(Station station) {
		Query query = new Query(Criteria.where("code").is(station.getCode()));
		Update update = new Update();
		update.set("services", station.getServices());
		update.set("prices", station.getPrices());
		update.set("fuelOuts", station.getFuelOuts());
		update.set("avaibility", station.getAvaibility());
		UpdateResult result = this.mongoTemplate.updateFirst(query, update, Station.class);
		if (result != null) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Page<Station> getStationByPage(int page) {
		final Pageable pageableRequest = PageRequest.of(page, Constants.TEN);
		Query query = new Query();
		query.with(pageableRequest);
		Query stationsDynamicQuery = new Query().with(pageableRequest)
				.with(new Sort(Sort.Direction.DESC, Constants.ORDER_FILED));
		List<Station> filteredStation = mongoTemplate.find(stationsDynamicQuery, Station.class,
				Constants.STATION_TABLE_NAME);
		Page<Station> stationPage = PageableExecutionUtils.getPage(filteredStation, pageableRequest,
				() -> mongoTemplate.count(stationsDynamicQuery, Station.class));
		return stationPage;
	}

	@Override
	public List<Station> findnearStation(double lon, double lat, double km) {
		Criteria criteria = new Criteria("geo").near(new Point(lon, lat)).maxDistance(getInKilometer(km));
		List<Station> tracks = mongoTemplate.find(new Query(criteria), Station.class);
		return tracks;
	}

	private Double getInKilometer(Double maxdistance) {

		return maxdistance / KILOMETER;

	}

}

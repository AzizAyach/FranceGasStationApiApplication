package com.ayach.francestation.repositories;



import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ayach.francestation.entity.Station;

public interface StationRepository extends MongoRepository<Station, Long> {
	
	List<Station> findBygeo(Point p);
	
	List<Station> findByPostal(Long postal);
	
	List <Station> findByVille (String ville);
	
	GeoResults<Station> findBygeoNear(Point location,Distance distance);
	
}

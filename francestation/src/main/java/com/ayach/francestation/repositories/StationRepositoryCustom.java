package com.ayach.francestation.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.ayach.francestation.entity.Station;

public interface StationRepositoryCustom {

	public boolean updateStation(Station station);
	
	public List<Station> findnearStation(double lang,double lat,double km);
	
	public Page<Station>  getStationByPage (int page) ;
}

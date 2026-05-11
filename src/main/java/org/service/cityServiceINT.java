package org.service;

import java.util.List;

import org.model.citymodel;

public interface cityServiceINT {
	
	public citymodel addNewCity(citymodel model);

	public List<citymodel> fetchAllCity();

	public List<citymodel> fetchCityUsingStateId(String sid);
	
	public boolean deleteCityById(String cid);	
	
	
	public citymodel fetchCityStateBoth(String cid);
	
	public boolean updateCity(citymodel model);




}

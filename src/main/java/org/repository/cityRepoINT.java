package org.repository;

import java.util.*;

import javax.sql.rowset.JoinRowSet;

import org.controller.updateCityServlet;
import org.model.citymodel;

import jakarta.enterprise.inject.Model;

public interface cityRepoINT {

	public citymodel addNewCity(citymodel model);
	
	public List<citymodel> fetchAllCity();
	
	
	public List<citymodel> fetchCityUsingStateId(String sid);
	
	public boolean deleteCityById(String cid);	
	
	
	public citymodel fetchCityStateBoth(String cid);
	
	
	public boolean updateCity(citymodel model);
	
	
}

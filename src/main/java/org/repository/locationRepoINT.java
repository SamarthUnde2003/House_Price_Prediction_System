package org.repository;

import java.util.*;

import org.model.locationmodel;

public interface locationRepoINT {
	
	
	public boolean addNewLocation(locationmodel model);
	
	public List<locationmodel> fetchLocationUsingCity(String sid);
	
	public boolean deleteLocationUsingId(String lid);
	

}

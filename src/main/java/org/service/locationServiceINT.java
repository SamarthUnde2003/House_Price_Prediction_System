package org.service;

import java.util.List;

import org.model.locationmodel;

public interface locationServiceINT {
	
	public boolean addNewLocation(locationmodel model);

	public List<locationmodel> fetchLocationUsingCity(String sid);
	
	public boolean deleteLocationUsingId(String lid);


}

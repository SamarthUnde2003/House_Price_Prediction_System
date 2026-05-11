package org.service;

import java.util.List;

import org.model.locationmodel;
import org.repository.locationRepo;
import org.repository.locationRepoINT;

public class locationService implements locationServiceINT{

	locationRepoINT repo = new locationRepo();
	
	public boolean addNewLocation(locationmodel model)
	{
		return repo.addNewLocation(model);
	}

	@Override
	public List<locationmodel> fetchLocationUsingCity(String sid) {
		
		return repo.fetchLocationUsingCity(sid);
	}

	@Override
	public boolean deleteLocationUsingId(String lid) {
		
		return repo.deleteLocationUsingId(lid);
	}

}

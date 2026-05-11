package org.service;

import java.util.List;

import org.model.citymodel;
import org.repository.cityRepo;
import org.repository.cityRepoINT;

public class cityService implements cityServiceINT {
	cityRepoINT cRepo = new cityRepo();
 	@Override
	public citymodel addNewCity(citymodel model) {
		return cRepo.addNewCity(model);
	}
	@Override
	public List<citymodel> fetchAllCity() {

		return cRepo.fetchAllCity();
	}
	@Override
	public List<citymodel> fetchCityUsingStateId(String sid) {
		return cRepo.fetchCityUsingStateId(sid);
	}
	@Override
	public boolean deleteCityById(String cid) {
		
		return cRepo.deleteCityById(cid);
	}
	@Override
	public citymodel fetchCityStateBoth(String cid) {
		// TODO Auto-generated method stub
		return cRepo.fetchCityStateBoth(cid);
	}
	@Override
	public boolean updateCity(citymodel model) {
		
		return cRepo.updateCity(model);
	}
	
	
	

}

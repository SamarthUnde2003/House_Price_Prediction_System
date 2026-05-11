package org.service;

import java.util.List;

import org.model.statemodel;
import org.repository.stateRepo;
import org.repository.stateRepoINT;

public class stateService implements stateServiceINT {
	stateRepoINT sRepo = new stateRepo();

	@Override
	public boolean addNewState(statemodel model) {

		return sRepo.addNewState(model);
	}

	@Override
	public List<statemodel> fetchAllStates() {

		return sRepo.fetchAllStates();
	}

	@Override
	public boolean deleteSate(int stateid) {
		return sRepo.deleteSate(stateid);
	}

	@Override
	public boolean updateStateById(statemodel model) {
		// TODO Auto-generated method stub
		return sRepo.updateStateById(model);
	}

	@Override
	public List<statemodel> fetchStateByName(String statename) {
		
		return sRepo.fetchStateByName(statename);
	}
	
	

}

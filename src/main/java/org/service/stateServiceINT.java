package org.service;

import java.util.List;

import org.model.statemodel;

public interface stateServiceINT {
	
	public boolean addNewState(statemodel model);
	
	public List<statemodel> fetchAllStates();
	
	public boolean deleteSate(int stateid);

	public boolean updateStateById(statemodel model);

	public List<statemodel> fetchStateByName(String statename);

}

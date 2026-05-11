package org.repository;

import java.util.*;

import org.model.statemodel;

public interface stateRepoINT {
	public boolean addNewState(statemodel model);
	
	
	public List<statemodel> fetchAllStates();
	
	public boolean deleteSate(int stateid);
	
	public boolean updateStateById(statemodel model);
	
	public List<statemodel> fetchStateByName(String statename);


	

}

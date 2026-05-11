package org.service;

import org.model.usermodel;
import org.repository.registerUser;

public class registerUserService implements registerUserINT {
	org.repository.registerUserINT rUserINT = new registerUser();

	@Override
	public usermodel validateRegUsermodel(usermodel model) {
		
		return rUserINT.registerUser(model);
	}
	
	
}

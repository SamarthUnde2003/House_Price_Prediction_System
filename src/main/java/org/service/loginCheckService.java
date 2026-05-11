package org.service;

import org.model.usermodel;
import org.repository.loginCheckRepo;
import org.repository.loginCheckRepoINT;




public class loginCheckService implements loginCheckServiceINT{
	loginCheckRepo lRepo = new loginCheckRepo();
	@Override
	public usermodel validateLogin(usermodel us) {
		return lRepo.validateLogin(us);
	}

}

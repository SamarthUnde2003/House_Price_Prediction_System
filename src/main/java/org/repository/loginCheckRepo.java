package org.repository;

import java.sql.ResultSet;

import org.dao.DBConfig;
import org.model.usermodel;

public class loginCheckRepo extends DBConfig implements loginCheckRepoINT {

	public loginCheckRepo() {
		super();
	}

	@Override
	public usermodel validateLogin(usermodel us) {
		
		try {
			ptst = conn.prepareStatement("select * from users where email = ? and password = ?  ");
			ptst.setString(1, us.getEmail());
			ptst.setString(2, us.getPassword());
			ResultSet rSet  = ptst.executeQuery();
			
			if (rSet.next()) {
				us.setUserid(rSet.getInt("uid"));
				us.setUsertype(rSet.getString("usertype"));
				return us;
			}
			else {
				return null;
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Some Internal Error Occurde while retriving data "+e);
			return null;
		}
	}
	
	
	

}

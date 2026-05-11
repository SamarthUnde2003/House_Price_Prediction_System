package org.repository;

import java.sql.SQLException;

import org.dao.DBConfig;
import org.model.usermodel;

public class registerUser extends DBConfig implements registerUserINT {

	@Override
	public usermodel registerUser(usermodel model) {
		try {
			ptst = conn.prepareStatement("insert into users values('0',?,?,?)");
			ptst.setString(1,model.getEmail());
			ptst.setString(2, model.getPassword());
			ptst.setString(3,model.getUsertype());
			int res = ptst.executeUpdate();
			
			if(res>0)
			{
				return model;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}

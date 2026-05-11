package org.repository;

import java.net.Authenticator.RequestorType;
import java.nio.channels.SelectableChannel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dao.DBConfig;
import org.model.locationmodel;

public class locationRepo extends DBConfig implements locationRepoINT {

	@Override
	public boolean addNewLocation(locationmodel model) {
		try {
			ptst = conn.prepareStatement("insert into location values('0',?,?)");
			ptst.setString(1,model.getLocationname());
			ptst.setInt(2,model.getCityid());
			int res =  ptst.executeUpdate();
			if(res>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
		
	}

	@Override
	public List<locationmodel> fetchLocationUsingCity(String sid) {
		try {
			
			List<locationmodel> list = new ArrayList<locationmodel>();
			ptst = conn.prepareStatement("select * from location where cid = ?");
			ptst.setString(1, sid);
			ResultSet rs = ptst.executeQuery();
			
			while(rs.next())
			{
				locationmodel m = new locationmodel();
				m.setLid(rs.getInt(1));
				m.setLocationname(rs.getString(2));
				m.setCityid(rs.getInt(3));
				list.add(m);
			}
			
			return list;
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	}

	@Override
	public boolean deleteLocationUsingId(String lid) {
		try {
			
			ptst = conn.prepareStatement("delete from location where lid = ?");
			ptst.setString(1, lid);
			int res = ptst.executeUpdate();
			
			if(res>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
		
	}
	

}

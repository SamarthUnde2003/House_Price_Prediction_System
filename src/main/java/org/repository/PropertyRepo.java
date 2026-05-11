package org.repository;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.controller.propertymodel;
import org.dao.DBConfig;



public class PropertyRepo extends DBConfig implements propertyRepoINT {

	public propertymodel addPropertymodel(propertymodel model) {
		
		try {
			ptst = conn.prepareStatement("insert into house values('0',?,?,?,?,?,?)");
			ptst.setString(1,model.getPname());
			ptst.setInt(2,model.getPage());
			ptst.setInt(3,model.getParea());
			ptst.setInt(4,model.getPbath());
			ptst.setInt(5,model.getPbed());
			ptst.setInt(6,model.getLid());
			int res =  ptst.executeUpdate();
			if(res>0)
			{
				return model;
			}
			else
			{
				return null;
			}
			
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	}

	@Override
	public List<propertymodel> fetchPropertyLocationWise(String lid) {
		
		try {
			List<propertymodel> list = new ArrayList<propertymodel>();
			ptst = conn.prepareStatement("select * from house where lid = ? order by hid");
			ptst.setString(1, lid);
			ResultSet rs =  ptst.executeQuery();
			while(rs.next())
			{
				propertymodel model = new propertymodel();
				model.setPid(rs.getInt(1));
				model.setPname(rs.getString(2));
				model.setPage(rs.getInt(3));
				model.setParea(rs.getInt(4));
				model.setPbath(rs.getInt(5));
				model.setPbed(rs.getInt(6));
				model.setLid(rs.getInt(7));
				
				list.add(model);
				

				
			}
			
			return list;
			
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	}

}

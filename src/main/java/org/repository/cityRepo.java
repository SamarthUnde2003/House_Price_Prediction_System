package org.repository;

import java.security.Identity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dao.DBConfig;
import org.model.citymodel;



import jakarta.enterprise.inject.Model;

public class cityRepo extends DBConfig implements cityRepoINT{

	@Override
	public citymodel addNewCity(citymodel model) {
		try {
			ptst = conn.prepareStatement("insert into city values('0',?,?)");
			ptst.setString(1,model.getCityname());
			ptst.setInt(2,model.getSid());
			int res =  ptst.executeUpdate();
			if (res>0) {
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
	public List<citymodel> fetchAllCity() {
		try {
			List<citymodel> list = new ArrayList<citymodel>();
			ptst = conn.prepareStatement("select * from city order by cid");
			
			ResultSet rs  = ptst.executeQuery();
			while(rs.next())
			{
				citymodel model = new citymodel();
				model.setCityid(rs.getInt(1));
				model.setCityname(rs.getString(2));
				model.setSid(rs.getInt(3));
				list.add(model);			
			}
			return list;
		} catch (Exception e) {
			e.getMessage();
		}
		
		return null;
	}

	@Override
	public List<citymodel> fetchCityUsingStateId(String sid) {
	
		try {
			
			
			ptst = conn.prepareStatement("select * from city where sid = ? ");
			ptst.setString(1, sid);
			ResultSet rSet = ptst.executeQuery();
			
			List<citymodel> list = new ArrayList<citymodel>();
			
			while(rSet.next())
			{
				citymodel model = new citymodel();
				model.setCityid(rSet.getInt(1));
				model.setCityname(rSet.getString(2));
				model.setSid(rSet.getInt(3));
				
				
				System.out.print(rSet.getInt(1));
				
				list.add(model);
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
		
	}

	@Override
	public boolean deleteCityById(String cid) {
		
		try {
			ptst = conn.prepareStatement("delete from city where cid = ?");
			
			ptst.setString(1,cid);
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
	public citymodel fetchCityStateBoth(String cid) {
		try {
			ptst = conn.prepareStatement("select cid,cityname ,s.sid,statename from city c join state s on c.sid=s.sid where cid = ?");
			ptst.setString(1,cid);
			ResultSet rSet = ptst.executeQuery();
			if(rSet.next())
			{
				citymodel model = new citymodel();
				model.setSid(rSet.getInt(3));
				model.setStatename(rSet.getString(4));
				model.setCityid(rSet.getInt(1));
				model.setCityname(rSet.getString(2));
				
				return model;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public boolean updateCity(citymodel model) {
		try {
			ptst = conn.prepareStatement(" update city set cityname = ? , sid = ? where cid = ?");
			
			ptst.setString(1,model.getCityname());
			ptst.setInt(2,model.getSid());
			ptst.setInt(3,model.getCityid());
			
			int res =  ptst.executeUpdate();
			
			if(res>0)
			{
				return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
		
	}

}

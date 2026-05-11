package org.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.dao.DBConfig;
import org.model.statemodel;

public class stateRepo extends DBConfig implements stateRepoINT{

	@Override
	public boolean addNewState(statemodel model) {
		try {
			ptst = conn.prepareStatement("insert into state values('0',?)");
			ptst.setString(1, model.getStatename());
			int rs = ptst.executeUpdate();
			if (rs>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<statemodel> fetchAllStates() {
		try {
			List<statemodel> list = new ArrayList<statemodel>();
			ptst = conn.prepareStatement("select * from state order by sid");
			ResultSet rs =  ptst.executeQuery();
			while (rs.next()) {
				statemodel model = new statemodel();
				model.setSid(rs.getInt("sid"));;
				model.setStatename(rs.getString("statename"));
				list.add(model);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}

	@Override
	public boolean deleteSate(int stateid) {
		try {
			ptst = conn.prepareStatement("delete from state where sid = ?");
			ptst.setInt(1,stateid);
			int res =  ptst.executeUpdate();
			if (res>0) {
				return true;
			}
			else {
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateStateById(statemodel model) {
		try {
			ptst = conn.prepareStatement("UPDATE state SET statename = ? WHERE sid = ?");
			ptst.setString(1,model.getStatename());
			ptst.setInt(2, model.getSid());
			int res = ptst.executeUpdate();
			if(res>0)
			{
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			System.out.println("Error is "+e);;
			return false;
		}
		
	}

	@Override
	public List<statemodel> fetchStateByName(String statename) {
		try {
			List<statemodel> list = new ArrayList<statemodel>();
			ptst = conn.prepareStatement("select * from state where statename like '%"+statename+"%' order by sid");
			ResultSet rs =  ptst.executeQuery();
			while (rs.next()) {
				statemodel model = new statemodel();
				model.setSid(rs.getInt("sid"));;
				model.setStatename(rs.getString("statename"));
				list.add(model);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

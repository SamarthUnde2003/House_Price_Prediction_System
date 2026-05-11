package org.model;

import lombok.Getter;
import lombok.Setter;


public class statemodel {
	private int sid ;
	private String statename;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	
	
	
}

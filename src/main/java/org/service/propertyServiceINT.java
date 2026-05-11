package org.service;

import java.util.List;

import org.controller.propertymodel;

public interface propertyServiceINT {
	
	public propertymodel addPropertymodel(propertymodel model);

	public List<propertymodel> fetchPropertyLocationWise(String lid);
	
	public  double predictPrice(double area, int age, int nbath, int nbed);
	
	
	



}

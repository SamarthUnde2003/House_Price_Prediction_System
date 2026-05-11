package org.service;

import java.util.List;

import org.controller.propertymodel;
import org.repository.PropertyRepo;
import org.repository.propertyRepoINT;

public class propertyService implements propertyServiceINT {
	
	propertyRepoINT pRep = new PropertyRepo();
	@Override
	public propertymodel addPropertymodel(propertymodel model) {
		
		return pRep.addPropertymodel(model);
		
		
	}
	@Override
	public List<propertymodel> fetchPropertyLocationWise(String lid) {
		
		return pRep.fetchPropertyLocationWise(lid.trim());
	}
	
	 public double predictPrice(double area, int age, int nbath, int nbed) {

	        // Coefficients (example values - replace with trained values)
		 
	        double b0 = 50000;    // intercept
	        double b1 = 1200;     // area coefficient
	        double b2 = -800;     // age coefficient
	        double b3 = 10000;    // bathroom coefficient
	        double b4 = 15000;    // bedroom coefficient

	        // Linear Regression Formula
	        
	        return b0 + (b1 * area) + (b2 * age) + (b3 * nbath) + (b4 * nbed);
	    }

}

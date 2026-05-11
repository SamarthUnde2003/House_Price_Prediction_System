package org.repository;

import java.security.cert.TrustAnchor;
import java.util.List;

import org.controller.fetchCityWiseLocation;
import org.controller.propertymodel;



public interface propertyRepoINT {
	public propertymodel addPropertymodel(propertymodel model);
	
	
	public List<propertymodel> fetchPropertyLocationWise(String lid);
}

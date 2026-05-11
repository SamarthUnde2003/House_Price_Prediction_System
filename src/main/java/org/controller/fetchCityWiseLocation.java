package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import org.model.citymodel;
import org.model.locationmodel;
import org.repository.locationRepo;
import org.service.locationService;
import org.service.locationServiceINT;
import org.w3c.dom.ls.LSOutput;

/**
 * Servlet implementation class fetchCityWiseLocation
 */
@WebServlet("/fetchCityWiseLocation")
public class fetchCityWiseLocation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String cityid = request.getParameter("ciid");
		
		
		
		locationServiceINT locservice = new locationService();
		
		List<locationmodel> list =  locservice.fetchLocationUsingCity(cityid);
		

	
		
		
		String str = " ";
		int count = 0;
		for (locationmodel model : list) {
			++count;
			str = str + "<tr>";

			str = str + "<th scope='row'>" + count + "</th>";

			str = str + "<td>" + model.getLocationname() + "</td>";

			str = str + "<td><a href=''>Update</a></td>";

			str = str + "<td><a href='deleteLocationServlet?lid="+model.getLid()+"'>Delete</a></td>";
			
			str = str + "</tr>";

		}
		
		out.println(str);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

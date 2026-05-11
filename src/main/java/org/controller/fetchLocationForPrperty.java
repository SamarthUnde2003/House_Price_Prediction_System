package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.citymodel;
import org.model.locationmodel;
import org.service.cityService;
import org.service.cityServiceINT;
import org.service.locationService;
import org.service.locationServiceINT;

/**
 * Servlet implementation class fetchLocationForPrperty
 */
@WebServlet("/fetchLocationForPrperty")
public class fetchLocationForPrperty extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String cidString = request.getParameter("ctid");
		
		
		locationServiceINT service = new locationService();
		List<locationmodel> list =  service.fetchLocationUsingCity(cidString);
		
		
		String str = "<option selected>Select City</option> ";
		int count = 0;
		for (locationmodel model : list) {
			++count;
			str = str + "<option value='"+model.getLid()+"'>"+model.getLocationname()+"</option>";
		}
		
		out.println(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

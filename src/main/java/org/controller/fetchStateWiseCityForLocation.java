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
import org.service.cityService;
import org.service.cityServiceINT;

/**
 * Servlet implementation class fetchStateWiseCityForLocation
 */
@WebServlet("/fetchStateWiseCityForLocation")
public class fetchStateWiseCityForLocation extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String sidString = request.getParameter("stid");
		
		
		cityServiceINT service = new cityService();
		List<citymodel> list =  service.fetchCityUsingStateId(sidString);
		
		
		String str = "<option selected>Select City</option> ";
		int count = 0;
		for (citymodel model : list) {
			++count;
			str = str + "<option value='"+model.getCityid()+"'>"+model.getCityname()+"</option>";
		}
		
		out.println(str);
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

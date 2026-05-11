package org.controller;

import jakarta.ejb.Stateless;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.locationmodel;
import org.model.statemodel;
import org.service.cityService;
import org.service.cityServiceINT;
import org.service.locationService;
import org.service.locationServiceINT;
import org.service.stateService;
import org.service.stateServiceINT;

/**
 * Servlet implementation class addLocation
 */
@WebServlet("/addLocation")
public class addLocation extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);
		
		
		stateServiceINT service = new stateService();
		List<statemodel> list =  service.fetchAllStates();
	

		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<form action='' method='post'>");
		out.println("<input type='text' class='form-control ' placeholder='Enter The Location Name' name='locationname' required />");
		out.println("<div class='mt-3'>");
		out.println("<select class='form-select ' id='stateOption' name='statee' aria-label='Floating label select example' onchange='changeCityForLoc()'>");
		out.println("<option selected>Select State</option>");
		
		
		for(statemodel model : list)
		{
			out.println("<option value='"+model.getSid()+"'>"+model.getStatename()+"</option>");
		}
		
		
		out.println("</select>");
		out.println("</div>");
		out.println("<div class='mt-3'>");
		out.println("<select class='form-select ' id='cityoptions' name='cityget' aria-label='Floating label select example'>");
		
		//fetch data from the ajax
		
		out.println("</select>");
		out.println("</div>");
		out.println("<div class='d-grid gap-2 col-6 mx-auto p-3'>");
		out.println("<button class='btn btn-primary' name='btn'>Add Location</button>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		
		
		if(request.getParameter("btn")!=null)
		{
			String locationnameString =  request.getParameter("locationname");
			int cityId  = Integer.parseInt(request.getParameter("cityget").trim());
			locationmodel model = new locationmodel();
			model.setLocationname(locationnameString);
			model.setCityid(cityId);
			
//			out.println("<h1>"+model.getCityid()+"\t"+model.getLocationname()+"</h1>");
			
			locationServiceINT locservice = new locationService();
			Boolean res =  locservice.addNewLocation(model);
			
			
			
			if(res)
			{
				out.println("<h1>Location Added Successfully</h1>");
			}
			else {
				out.println("<h1>Location Not Added</h1>");
			}
			
		}
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

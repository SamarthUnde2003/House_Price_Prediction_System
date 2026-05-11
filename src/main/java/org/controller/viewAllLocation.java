package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.statemodel;
import org.service.stateService;
import org.service.stateServiceINT;

/**
 * Servlet implementation class viewAllLocation
 */
@WebServlet("/viewAllLocation")
public class viewAllLocation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);
		
		
		stateServiceINT service = new stateService();
		List<statemodel> list =  service.fetchAllStates();
	

		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<form action='' method='post'>");
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
		out.println("<select class='form-select ' id='cityoptions' name='cityget' aria-label='Floating label select example'  onchange='fetchLocationUsingCity()'>");
		
		//fetch data from the ajax
		
		out.println("</select>");
		out.println("</div>");
		out.println("<div class='d-grid  mx-auto p-3'>");
		
		out.println("<table class='table table-striped'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th scope='col'>Sr No</th>");
		out.println("<th scope='col'>Name</th>");
		out.println("<th scope='col'>Update</th>");
		out.println("<th scope='col'>Delete</th>");
		out.println("</tr>");
		out.println("</thead>");

		
		out.println("<tbody id ='locationtablebody' class='text-white'>");
	
		out.println("</tbody>");

		out.println("</table>");
		
		out.println("</div>");
		out.println("</form>");
		
		
		out.println("</div>");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

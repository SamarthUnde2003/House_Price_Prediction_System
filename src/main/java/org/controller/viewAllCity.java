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
import org.service.cityService;
import org.service.cityServiceINT;
import org.service.stateService;
import org.service.stateServiceINT;

/**
 * Servlet implementation class viewAllCity
 */
@WebServlet("/viewAllCity")
public class viewAllCity extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);

		stateServiceINT service = new stateService();
		List<statemodel> list = service.fetchAllStates();
		int count = 0;

		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<h1 class=\"display-4 text-white text-center text-decoration-underline\">Cities</h1>");
		out.println("<div class='m-3'>");
		out.println("<select class='form-select ' id='citystatehandel' name='statee' aria-label='Floating label select example' onChange='fetchCities()' > ");
		out.println("<option selected value=''>Select State</option>");
		
		
		for(statemodel model : list)
		{
			out.println("<option value='"+model.getSid()+"'>"+model.getStatename()+"</option>");
		}
		
		out.println("</select>");
		out.println("</div>");
		out.println("<table class='table table-striped'>");

		out.println("<thead>");
		
		
		out.println("<tr>");
		out.println("<th scope='col'>Sr No</th>");
		out.println("<th scope='col'>Name</th>");
		out.println("<th scope='col'>Update</th>");
		out.println("<th scope='col'>Delete</th>");
		out.println("</tr>");
		out.println("</thead>");

		
		out.println("<tbody id ='citytablebody' class='text-white'>");
		
	
		
		out.println("</tbody>");

		out.println("</table>");
		out.println("</div>");
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

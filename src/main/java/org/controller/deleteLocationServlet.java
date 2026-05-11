package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.service.locationService;
import org.service.locationServiceINT;

/**
 * Servlet implementation class deleteLocationServlet
 */
@WebServlet("/deleteLocationServlet")
public class deleteLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String locationidString = request.getParameter("lid");
		
		
		locationServiceINT service = new locationService();
		boolean res =  service.deleteLocationUsingId(locationidString);
		if (res) {
			response.sendRedirect("viewAllLocation");
		}else {
			out.print("<h1>Unable to delete the Location</h1>");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

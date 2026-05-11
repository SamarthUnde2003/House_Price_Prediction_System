package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.service.stateService;
import org.service.stateServiceINT;

@WebServlet("/deleteState")
public class deleteState extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);
		
		
		int stateid = Integer.parseInt(request.getParameter("stateid"));
	
		
		stateServiceINT service = new stateService();
		
		boolean res =  service.deleteSate(stateid);
		
		if (res) {
			response.sendRedirect("viewAllStates");
		}
		else {
			out.println("<h1 class=\"display-4 text-white text-center text-decoration-underline\">No State Deleted</h1>");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

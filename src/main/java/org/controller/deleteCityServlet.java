package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.service.cityService;
import org.service.cityServiceINT;


@WebServlet("/deleteCityServlet")
public class deleteCityServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String cityid = request.getParameter("cid");
		
		cityServiceINT service = new cityService();
	 	boolean res =  service.deleteCityById(cityid);
	 	if(res)
	 	{
	 		response.sendRedirect("viewAllCity");
	 	}
	 	else
	 	{
	 		out.println("<h1>Unable to Delete City</h1>");
	 	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

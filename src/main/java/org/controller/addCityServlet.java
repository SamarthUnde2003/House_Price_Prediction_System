package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;

import org.model.citymodel;
import org.model.statemodel;
import org.service.cityService;
import org.service.cityServiceINT;
import org.service.stateService;
import org.service.stateServiceINT;

/**
 * Servlet implementation class addCityServlet
 */
@WebServlet("/addCityServlet")
public class addCityServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);
		
		
		stateServiceINT service = new stateService();
		List<statemodel> list =  service.fetchAllStates();

		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<form action='' method='post'>");
		out.println(
				"<input type='text' class='form-control ' placeholder='Enter The City Name' name='cityname' required />");
		out.println("<div class='mt-3'>");
		out.println("<select class='form-select ' id='floatingSelect' name='statee' aria-label='Floating label select example'>");
		out.println("<option selected>Select State</option>");
		
		
		for(statemodel model : list)
		{
			out.println("<option value='"+model.getSid()+"'>"+model.getStatename()+"</option>");
		}
		
		out.println("</select>");
		out.println("</div>");
		out.println("<div class='d-grid gap-2 col-6 mx-auto p-3'>");
		out.println("<button class='btn btn-primary' name='btn'>Add City</button>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");
		
		
		String btn = request.getParameter("btn");
		
		if(btn!=null)
		{
			
			citymodel mCitymodel = new citymodel();
			mCitymodel.setCityname(request.getParameter("cityname"));
			mCitymodel.setSid(Integer.parseInt(request.getParameter("statee")));
			cityServiceINT cservice = new cityService();
			citymodel modelresult  =  cservice.addNewCity(mCitymodel);
			if (modelresult!=null) {
				out.println("<h1>City Added Sucessfully</h1>");
			}else {
				out.println("<h1>City Not Added</h1>");
			}
			
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

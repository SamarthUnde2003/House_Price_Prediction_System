package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.locationmodel;
import org.service.propertyService;
import org.service.propertyServiceINT;


@WebServlet("/fetchPropertyUsingLocation")
public class fetchPropertyUsingLocation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String lid = request.getParameter("lid");
		
		
		System.out.println("location id is"+lid);
		
		
		propertyServiceINT service = new propertyService();
		List<propertymodel> list =  service.fetchPropertyLocationWise(lid);
		
		
		String str = " ";
		int count = 0;
		for (propertymodel model : list) {
			
			double finalprice =  service.predictPrice(model.getParea(),model.getPage(),model.getPbath(),model.getPbed());
			++count;
			str = str + "<tr>";

			str = str + "<th scope='row'>" + count + "</th>";

			str = str + "<td>" + model.getPname() + "</td>";
			
			str = str + "<td>" + model.getPage() + "</td>";
			
			str = str + "<td>" + model.getParea() + "</td>";
			
			str = str + "<td>" + model.getPbath() + "</td>";
			
			str = str + "<td>" + model.getPbed() + "</td>";
			
			str = str + "<td>" + finalprice + "</td>";

			str = str + "<td><a href=''>Update</a></td>";

			str = str + "<td><a href=''>Delete</a></td>";
			
			str = str + "</tr>";

		}
		
		out.println(str);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

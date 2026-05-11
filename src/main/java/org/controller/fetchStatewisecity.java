package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.Pipe.SourceChannel;
import java.util.List;

import org.model.citymodel;
import org.model.statemodel;
import org.service.cityService;
import org.service.cityServiceINT;

/**
 * Servlet implementation class fetchStatewisecity
 */
@WebServlet("/fetchStatewisecity")
public class fetchStatewisecity extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String stateid = request.getParameter("stid");
		
		
		cityServiceINT service = new cityService();
		List<citymodel> list =  service.fetchCityUsingStateId(stateid);
		
		
		
		String str = " ";
		int count = 0;
		for (citymodel model : list) {
			++count;
			str = str + "<tr>";

			str = str + "<th scope='row'>" + count + "</th>";

			str = str + "<td>" + model.getCityname() + "</td>";

			str = str + "<td><a href='updateCityServlet?cid= "+model.getCityid()+"'>Update</a></td>";

			str = str + "<td><a href='deleteCityServlet?cid= "+model.getCityid()+" '>Delete</a></td>";
			
			str = str + "</tr>";

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

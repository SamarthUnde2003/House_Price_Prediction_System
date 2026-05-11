package org.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.client.ResponseProcessingException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.statemodel;
import org.service.stateService;
import org.service.stateServiceINT;

/**
 * Servlet implementation class searchStateByName
 */
@WebServlet("/searchStateByName")
public class searchStateByName extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String stateString = request.getParameter("s");
		stateServiceINT service = new stateService();
		List<statemodel> list = service.fetchStateByName(stateString);
		String str = "";
		int count = 0;
		for (statemodel model : list) {
			++count;
			str = str + "<tr>";

			str = str + "<th scope='row'>" + count + "</th>";

			str = str + "<td>" + model.getStatename() + "</td>";

			str = str + "<td><a href='updateStateServlet?stateid=" + model.getSid() + "&statename= "
					+ model.getStatename() + "'>Update</a></td>";

			str = str + "<td><a href='deleteState?stateid=" + model.getSid() + "'>Delete</a></td>";
			str = str + "</tr>";

		}
		
		out.print(str);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

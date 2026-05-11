package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.model.statemodel;
import org.service.stateService;
import org.service.stateServiceINT;

/**
 * Servlet implementation class viewAllStates
 */
@WebServlet("/viewAllStates")
public class viewAllStates extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);

		stateServiceINT service = new stateService();
		List<statemodel> list = service.fetchAllStates();
		int count = 0;

		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<h1 class=\"display-4 text-white text-center text-decoration-underline\">States</h1>");
		out.println("<table class='table table-striped'>");
		out.println("<div class='input-group mb-3'>");
		out.println(
				"<input type='text' class='form-control' placeholder='SEARCH' aria-label='Username' name='searchState' aria-describedby='basic-addon1' onkeyup='searchstate(this.value)'> " );
		out.println("	</div>");
		out.println("<thead>");
		
		out.println("<tr>");
		out.println("<th scope='col'>Sr No</th>");
		out.println("<th scope='col'>State Name</th>");
		out.println("<th scope='col'>Update</th>");
		out.println("<th scope='col'>Delete</th>");
		out.println("</tr>");
		out.println("</thead>");

		
		out.println("<tbody id ='tbodyy'>");
		
		for (statemodel model : list) {     
			++count;
			out.println("<tr>");
			out.println("<th scope='row'>" + count + "</th>");
			out.println("<td>" + model.getStatename() + "</td>");

			out.println("<td><a href='updateStateServlet?stateid=" + model.getSid() + "&statename= "
					+ model.getStatename() + "'>Update</a></td>");
			out.println("<td><a href='deleteState?stateid=" + model.getSid() + "'>Delete</a></td>");
			out.println("</tr>");
		}

		out.println("</tbody>");

		out.println("</table>");
		out.println("</div>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

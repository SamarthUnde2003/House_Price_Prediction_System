package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.statemodel;
import org.service.stateService;
import org.service.stateServiceINT;

/**
 * Servlet implementation class userDashboardServlet
 */
@WebServlet("/userDashboardServlet")
public class userDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("/userdashboard.html");
		rd.include(request, response);
		HttpSession ses = request.getSession();
		String uname = (String) ses.getAttribute("uname");
		out.println("<h2>Welcome "+uname+"</h2>");
		
		stateServiceINT service = new stateService();
		List<statemodel> list = service.fetchAllStates();

		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<form action='' method='post'>");

		out.println("<div class='mt-3'>");
		out.println(
				"<select class='form-select ' id='stateOption' name='statee' aria-label='Floating label select example' onchange='changeCityForLoc()'>");
		out.println("<option selected>Select State</option>");

		for (statemodel model : list) {
			out.println("<option value='" + model.getSid() + "'>" + model.getStatename() + "</option>");
		}

		out.println("</select>");
		out.println("</div>");
		out.println("<div class='mt-3'>");
		out.println(
				"<select class='form-select ' id='cityoptions' name='cityget' aria-label='Floating label select example' onchange='changeLocationforProperty()'  >");

		// fetch data from the ajax

		out.println("</select>");
		out.println("</div>");

		out.println("<div class='mt-3'>");
		out.println(
				"<select class='form-select ' id='locationoptions' name='locationget' aria-label='Floating label select example' onchange='fetchPrpertyOnLocationChangeforuser()' >");

		// fetch data from the ajax

		out.println("</select>");
		out.println("</div>");
		

		out.println("<table class='table table-striped mt-3'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th scope='col'>Sr No</th>");
		out.println("<th scope='col'>Name</th>");
		out.println("<th scope='col'>Age</th>");
		out.println("<th scope='col'>Area</th>");
		out.println("<th scope='col'>Bath</th>");
		out.println("<th scope='col'>Bed</th>");
		out.println("<th scope='col'>Price</th>");
	
		out.println("</tr>");
		out.println("</thead>");

		
		out.println("<tbody id ='propertytablebody' class='text-white'>");

		out.println("</tbody>");

		out.println("</table>");

		
		out.println("</form>");
		out.println("</div>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

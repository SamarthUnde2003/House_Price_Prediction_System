package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.model.statemodel;
import org.service.stateService;
import org.service.stateServiceINT;

/**
 * Servlet implementation class addStateServlet
 */
@WebServlet("/addStateServlet")
public class addStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);
		
		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<form action='' method='post'>");
	    out.println("<input type='text' class='form-control ' placeholder='Enter The State Name' name='statename' required />");
	    out.println("<div class='d-grid gap-2 col-6 mx-auto p-3'>");
	    out.println("<button class='btn btn-primary' name='btn'>Add State</button>");
	    out.println("</div>");
	    out.println("</form>");
	    out.println("</div>");
	    
	    
	    
	    
	    if(request.getParameter("btn")!=null)
	    {
	    	
	    	String statename = request.getParameter("statename");
	    	statemodel model = new statemodel();
	    	model.setStatename(statename);
	    	stateServiceINT serviceINT = new stateService();
	    	boolean res=  serviceINT.addNewState(model);
	    	if (res) {
				out.println("<h1>State Added Successfully.....</h1>");
			}
	    	else {
	    		out.println("<h1>State Not Added.....</h1>");
			}
	    }
	    
	    
	    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
 * Servlet implementation class updateStateServlet
 */
@WebServlet("/updateStateServlet")
public class updateStateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);
		
		String statename = request.getParameter("statename");
		int  sid = Integer.parseInt(request.getParameter("stateid"));
		
		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<form action='' method='post'>");
	    out.println("<input type='text' class='form-control  mt-2' placeholder='Enter The State Name' name='newid' value='"+sid+"' required disabled/>");
	    out.println("<input type='text' class='form-control mt-2 ' placeholder='Enter The State Name' name='newname' value='"+statename+"' required />");
	    out.println("<div class='d-grid gap-2 col-6 mx-auto p-3'>");
	    out.println("<button class='btn btn-primary' name='btn'>Update State</button>");
	    out.println("</div>");
	    out.println("</form>");
	    out.println("</div>");
	    String btn = request.getParameter("btn");
	    if(btn!=null)
	    {
	    	statemodel model = new statemodel();
	    	model.setSid(sid);
	    	model.setStatename(request.getParameter("newname"));
	    	
	    	stateServiceINT service = new stateService();
	    	
	    	boolean res  = service.updateStateById(model);
	    	
	    	if(res)
	    	{
	    		out.print("<h1>State Updated Successfully</h1>");	
	    	}
	    	else {
	    		
	    		out.print("<h1>State Not Updated </h1>");
			}
	    	
	    	
	    }
	    
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

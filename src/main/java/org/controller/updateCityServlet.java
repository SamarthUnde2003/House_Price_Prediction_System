package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.model.citymodel;
import org.model.statemodel;
import org.service.cityService;
import org.service.cityServiceINT;
import org.service.stateServiceINT;



/**
 * Servlet implementation class updateCityServlet
 */
@WebServlet("/updateCityServlet")
public class updateCityServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);
		
		
		String cidString = request.getParameter("cid");
		
		cityServiceINT service = new cityService();
		citymodel model =  service.fetchCityStateBoth(cidString);
		
		stateServiceINT stateService = new org.service.stateService();
	    List<statemodel> list = stateService.fetchAllStates();
	    
		
		
		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<form action='' method='post'>");
	    out.println("<input type='text' class='form-control  mt-2' placeholder='Enter The State Name' name='cid' value='"+model.getCityid()+"' required disabled/>");
	    out.println("<input type='text' class='form-control mt-2 ' placeholder='Enter The State Name' name='newname' value='"+model.getCityname()+"' required />");
	    out.println("<div class='mt-3'>");
		out.println("<select class='form-select ' id='floatingSelect' name='statee' aria-label='Floating label select example'>");
		out.println("<option selected>Select State</option>");
		
		
		for(statemodel smodel : list)
		{
			out.println("<option value='"+smodel.getSid()+"'>"+smodel.getStatename()+"</option>");
		}
		
		out.println("</select>");
		out.println("</div>");
	    out.println("<div class='d-grid gap-2 col-6 mx-auto p-3'>");
	   
	    out.println("<button class='btn btn-primary' name='btn'>Update State</button>");
	    out.println("</div>");
	    out.println("</form>");
	    out.println("</div>");
	    
	    
	    
	    
	    String btnvalue = request.getParameter("btn");
	    
	    if(btnvalue!=null)
	    {
	    	
	    	citymodel sendmodel = new citymodel();
	    	sendmodel.setCityid(Integer.parseInt(request.getParameter("cid").trim()));
	    	sendmodel.setCityname(request.getParameter("newname"));
	    	sendmodel.setSid(Integer.parseInt(request.getParameter("statee")));
	    	
	    	Boolean res =  service.updateCity(sendmodel);
	    	
	    	if(res)
	    	{
	    		out.println("<h1>City Updated Sucessfully</h1>");
	    	}
	    	else {
	    		out.println("<h1>City Not Updated</h1>");
			}
	    	
	    	
	    	
	    }
	    else {
			out.print("hhshsh");
		}
	    
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

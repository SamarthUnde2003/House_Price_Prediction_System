package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.StringConcatFactory;
import java.util.List;

import org.model.locationmodel;
import org.model.statemodel;
import org.service.propertyService;
import org.service.propertyServiceINT;
import org.service.stateService;
import org.service.stateServiceINT;


@WebServlet("/addNewProperty")
public class addNewProperty extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);
		
		stateServiceINT service = new stateService();
		List<statemodel> list =  service.fetchAllStates();
		
		
		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<form action='' method='post'>");
	    out.println("<input type='text' class='form-control mt-3' placeholder='Enter Property Name' name='prtname' required />");
	    out.println("<input type='number' class='form-control mt-3' placeholder='Enter Property Age' name='prtage' required />");
	    out.println("<input type='number' class='form-control mt-3' placeholder='Enter Property Area' name='prtarea' required />");
	    out.println("<input type='number' class='form-control mt-3' placeholder='Enter No Of Bath' name='prtbath' required />");
	    out.println("<input type='number' class='form-control mt-3' placeholder='Enter No Of Bed' name='prtbed' required />");
	    
	    out.println("<div class='mt-3'>");
		out.println("<select class='form-select ' id='stateOption' name='statee' aria-label='Floating label select example' onchange='changeCityForLoc()'>");
		out.println("<option selected>Select State</option>");
		
		
		for(statemodel model : list)
		{
			out.println("<option value='"+model.getSid()+"'>"+model.getStatename()+"</option>");
		}
		
		
		out.println("</select>");
		out.println("</div>");
		out.println("<div class='mt-3'>");
		out.println("<select class='form-select ' id='cityoptions' name='cityget' aria-label='Floating label select example' onchange='changeLocationforProperty()'  >");
		
		//fetch data from the ajax
		
		out.println("</select>");
		out.println("</div>");
		
		out.println("<div class='mt-3'>");
		out.println("<select class='form-select ' id='locationoptions' name='locationget' aria-label='Floating label select example'>");
		
		//fetch data from the ajax
		
		out.println("</select>");
		out.println("</div>");
	    out.println("<div class='d-grid gap-2 col-6 mx-auto p-3'>");
	    out.println("<button class='btn btn-primary' name='btn'>Add Property</button>");
	    out.println("</div>");
	    out.println("</form>");
	    out.println("</div>");
	    
	    
	    
	    String btn = request.getParameter("btn");
	    if(btn!=null)
	    {
	    	 String prtname =  request.getParameter("prtname");
	    	 int prtage = Integer.parseInt(request.getParameter("prtage").trim());
	    	 int prtarea = Integer.parseInt(request.getParameter("prtarea").trim());
	    	 int prtbath = Integer.parseInt(request.getParameter("prtbath").trim());
	    	 int prtbed = Integer.parseInt(request.getParameter("prtbed").trim());
	    	 int prtlocation = Integer.parseInt(request.getParameter("locationget").trim());

	    	 
	    	 
	    	propertymodel model = new propertymodel();
	    	model.setPname(prtname);
	    	model.setPage(prtage);
	    	model.setParea(prtarea);
	    	model.setPbath(prtbath);
	    	model.setPbed(prtbed);
	    	model.setLid(prtlocation);
	    	 
	    	propertyServiceINT pservice = new propertyService();
	    	propertymodel  resmodel =   pservice.addPropertymodel(model);
	    	
	    	if(resmodel!=null)
	    	{
	    		out.println("<h1>Property Added SucessFully</h1>");
	    	}
	    	else {
	    		out.println("<h1>Property Not Added</h1>");
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

package org.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.model.usermodel;
import org.service.registerUserService;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String emailString = request.getParameter("email"); 
		String pass1String = request.getParameter("pass1");
		String pass2String = request.getParameter("pass2");

		if (pass1String.equals(pass2String)) {
			usermodel mUsermodel = new usermodel();
			registerUserService rUserService = new registerUserService(); 
			mUsermodel.setEmail(emailString);
			mUsermodel.setPassword(pass1String);
			mUsermodel.setUsertype("user");
			
			usermodel res =  rUserService.validateRegUsermodel(mUsermodel);
			
			if (res!=null) {
				out.println("<script> alert(\"User ADDED Succesfully.\");</script>");
				
			}
			else {
				out.println("<script> alert(\"Some Error occured while adding user.\");</script>");
			}
			
		
			
			
		}else {
			out.println("<script> alert(\"PLEASE ENTER SIMILAR PASSWORDS.\");</script>");
			
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

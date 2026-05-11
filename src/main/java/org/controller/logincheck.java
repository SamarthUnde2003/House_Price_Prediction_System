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

import org.model.usermodel;
import org.service.loginCheckService;
import org.service.loginCheckServiceINT;

/**
 * Servlet implementation class logincheck
 */
@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String emailString = request.getParameter("email");
		String passString = request.getParameter("password");
		
		usermodel us = new usermodel();
		us.setEmail(emailString);
		us.setPassword(passString);
		
		
		
		
		loginCheckService lServiceINT = new loginCheckService();
		
		usermodel model = lServiceINT.validateLogin(us);
		
		if (model!=null) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("uname",model.getEmail());
			
			
			if (model.getUsertype().equals("admin")) {
				RequestDispatcher rd = request.getRequestDispatcher("admindashboard.html");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("./userDashboardServlet");
				rd.forward(request, response);
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("pop.html");
			rd.forward(request, response);
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

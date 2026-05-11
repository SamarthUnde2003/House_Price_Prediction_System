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
import org.repository.registerUser;
import org.repository.registerUserINT;

@WebServlet("/addNewAdmin")
public class addNewAdmin extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rDispatcher = request.getRequestDispatcher("admindashboard.html");
		rDispatcher.include(request, response);

		out.println("<div class='box bg-dark p-5 m-5'>");
		out.println("<form action='' method='post'>");
		out.println(
				"<input type='text' class='form-control ' placeholder='Enter The Admin Email' name='username' required />");
		out.println(
				"<input type='text' class='form-control mt-3' placeholder='Enter The Admin Password' name='password' required />");
		out.println("<div class='d-grid gap-2 col-6 mx-auto p-3'>");
		out.println("<button class='btn btn-primary' name='btn'>Add Admin</button>");
		out.println("</div>");
		out.println("</form>");
		out.println("</div>");

		if (request.getParameter("btn") != null) {
			String email = request.getParameter("username");
			String pass = request.getParameter("password");

			usermodel model = new usermodel();
			model.setEmail(email);
			model.setPassword(pass);
			model.setUsertype("admin");

			registerUserINT service = new registerUser();

			usermodel resmodel = service.registerUser(model);

			if (model != null) {
				out.println("<h1>User Added Sucessfully</h1>");
			} else {
				out.print("<h1>User Not Added</h1>");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out= response.getWriter();
//		out.print("working");
		
		//here we store or get infromation from registration page variables are below
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String upwd=request.getParameter("pass");
		String umobile=request.getParameter("contact");
		
		//lets print all the input we get write or not
		PrintWriter out=response.getWriter();
		out.print(uname);
		out.print(uemail);
		out.print(upwd);
		out.print(umobile);
	}

}

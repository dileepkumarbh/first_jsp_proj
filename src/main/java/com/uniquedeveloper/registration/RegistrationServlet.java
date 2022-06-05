package com.uniquedeveloper.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
//		PrintWriter out=response.getWriter();
//		out.print(uname);
//		out.print(uemail);
//		out.print(upwd);
//		out.print(umobile);
		
		RequestDispatcher dispatcher=null;
		
		// now databases
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup","root","root");
			PreparedStatement pst=con.prepareStatement("insert into user(uname,upwd,uemail,umobile) values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, upwd);
			pst.setString(3, uemail);
			pst.setString(4, umobile);
			
			int rowCoung=pst.executeUpdate();
			dispatcher=request.getRequestDispatcher("registration.jsp");
			if(rowCoung>0) {
				request.setAttribute("status","success");
				
			}else {
				request.setAttribute("status","failed");
			}
			dispatcher.forward(request, response);
			
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

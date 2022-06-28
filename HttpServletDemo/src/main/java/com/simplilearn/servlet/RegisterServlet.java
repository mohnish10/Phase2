package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
resp.setContentType("text.html");
PrintWriter out = resp.getWriter();
String fname=req.getParameter("fname");
String lname=req.getParameter("lname");
String email=req.getParameter("email");
String pass=req.getParameter("pass");


out.print("<h1>Successfully registered</h1><br<br>");
out.print("Following are the successfully registered details <br><br>");
out.print("<p> First name :"+fname+"<br><br>");
out.print("<p> Last name : "+lname+"<br><br>");
out.print("<p> Email :"+email+"<br><br>");
	
	
	
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

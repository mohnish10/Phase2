package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet implements Servlet
{

	private ServletConfig config;

	@Override
	public void destroy() {
System.out.println("Servlet has been destroyed");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return config.getServletName()+"";
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
System.out.println("Servlet has been initialized");
this.config=config;
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException 
	{
System.out.println("request recieved");
PrintWriter out = resp.getWriter();
resp.setContentType("text/html");
out.print("Welcome<br>");
out.print(getServletInfo());
out.print("<br> details <br>");
out.print("Content length :"+req.getContentLength()+"<br");
out.print("Content type :"+req.getContentType());
	
	
	
	}








}

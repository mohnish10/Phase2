package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/my")
public class MyServlet implements Servlet
{

private ServletConfig config;

public void destroy()
{
System.out.println("Servlet destroyed");
}

public ServletConfig getServletConfig()
{
return config;	
}

public String getServletInfo()
{
return config.getServletName()+"";
}


public void init(ServletConfig config) throws ServletException
{
System.out.println("Servlet initialized");
this.config = config;	
}


public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
{
System.out.println("Request recieved");
PrintWriter out = resp.getWriter();
resp.setContentType("text/html");
out.print("Welcome<br>");
out.print(getServletInfo());
out.print("<br> Details<br>");
out.print("Content length" +req.getContentLength()+"<br>");
out.print("Content type" +req.getContentType());
}
}


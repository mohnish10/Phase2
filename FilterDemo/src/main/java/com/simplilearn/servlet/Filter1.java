package com.simplilearn.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/welcome")
public class Filter1 implements Filter
{
	
public void init(FilterConfig filterConfig) throws ServletException
{
System.out.println("Filter initialized");	
}


public void destroy()
{
System.out.println("Filter has been destroyed");	
}



	
	
	
	
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException 
	{
resp.setContentType("text/html");
PrintWriter out = resp.getWriter();
out.print("Pre-filtration of first filter <br>");
chain.doFilter(req, resp);
out.print("Post Filteration of first filter<br>");
}

}

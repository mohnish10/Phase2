package com.simplilearn.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	PrintWriter out = response.getWriter();
	out.print("Mentioned below are the products and their respective details");
	String name=request.getParameter("name");
	String id=request.getParameter("id");
	String price=request.getParameter("price");
	String quantity=request.getParameter("quantity");
	Product p = new Product();
	p.setId(1);
	p.setName("Lenovo laptop");
	p.setPrice((float) 25000.37);
	p.setQuantity(5);
	p.setId(2);
	p.setName("Playstation 8");
	p.setPrice((float) 35689.50);
	p.setQuantity(3);
	p.setId(3);
	p.setName("Bingo masala chips");
	p.setPrice((float) 150.35);
	p.setQuantity(10);	
	HttpSession session = request.getSession();
	session.setAttribute("saveProduct",p);
	response.sendRedirect("success.jsp");	
		
		
	
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

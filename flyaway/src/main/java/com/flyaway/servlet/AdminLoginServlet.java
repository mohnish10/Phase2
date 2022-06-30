package com.flyaway.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.db.AdminDB;
import com.flyaway.model.Admin;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("adminLogin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("loginServlet");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("received email "+email+" and password "+password);
		AdminDB admindb = new AdminDB();
		boolean authenticated = admindb.validateUser(new Admin(email, password));
		if (!authenticated) {
			response.sendRedirect("adminLogin.jsp?error=Invalid Credentials");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("admindashboard.jsp");
		}
	}

}
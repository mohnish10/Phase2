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
 * Servlet implementation class adminPassword
 */
@WebServlet("/adminPassword")
public class AdminPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("adminLogin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String password = request.getParameter("password");
		if(email == null) {
			response.sendRedirect("adminLogin.jsp");
		} else {
			AdminDB admindb = new AdminDB();
			Admin admin = new Admin(email, password);
			if(admindb.updatePassword(admin)) {
				response.sendRedirect("admindashboard.jsp?message=password changed");
			}
		}
	}

}
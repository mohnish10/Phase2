package com.flyaway.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.db.AirlinesDB;
import com.flyaway.model.Airline;

/**
 * Servlet implementation class ListAirlinesServlet
 */
@WebServlet("/listAirlines")
public class ListAirlinesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAirlinesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if(email == null) {
			response.sendRedirect("adminLogin.jsp");
		} else {
			AirlinesDB airlinesdb = new AirlinesDB(); 
			List<Airline> airlines = airlinesdb.getAllAirlines();
			RequestDispatcher dispatcher = request.getRequestDispatcher("listAirlines.jsp");
			request.setAttribute("airlinelist", airlines);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
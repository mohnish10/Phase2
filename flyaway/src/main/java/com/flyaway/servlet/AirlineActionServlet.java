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
 * Servlet implementation class AirlineActionServlet
 */
@WebServlet("/airlineAction")
public class AirlineActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AirlineActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String action = request.getParameter("action");
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		if(email == null) {
			response.sendRedirect("adminLogin.jsp");
		} else {
			AirlinesDB airlinesdb = new AirlinesDB(); 
			if (action.equals("delete")) {
				airlinesdb.deleteAirline(id);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("listAirlines");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * on Post add airline
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String aname = request.getParameter("aname");
		if(email == null) {
			response.sendRedirect("adminLogin.jsp");
		} else {
			AirlinesDB airlinesdb = new AirlinesDB(); 
			airlinesdb.addAirline(new Airline(aname));
			RequestDispatcher dispatcher = request.getRequestDispatcher("listAirlines");
			dispatcher.forward(request, response);
		}
	}

}
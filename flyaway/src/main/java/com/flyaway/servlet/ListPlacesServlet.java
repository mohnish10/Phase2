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
import com.flyaway.db.PlacesDB;
import com.flyaway.model.Airline;
import com.flyaway.model.Place;

/**
 * Servlet implementation class ListPlacesServlet
 */
@WebServlet("/listPlaces")
public class ListPlacesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPlacesServlet() {
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
			PlacesDB placesdb = new PlacesDB(); 
			List<Place> places = placesdb.getAllPlaces();
			RequestDispatcher dispatcher = request.getRequestDispatcher("listPlaces.jsp");
			request.setAttribute("placelist", places);
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
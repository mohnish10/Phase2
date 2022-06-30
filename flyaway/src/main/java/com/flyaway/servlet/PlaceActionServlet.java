package com.flyaway.servlet;

import java.io.IOException;

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
 * Servlet implementation class PlaceActionServlet
 */
@WebServlet("/placeAction")
public class PlaceActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceActionServlet() {
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
			PlacesDB placesdb = new PlacesDB(); 
			if (action.equals("delete")) {
				placesdb.deletePlace(id);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("listPlaces");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String pname = request.getParameter("pname");
		if(email == null) {
			response.sendRedirect("adminLogin.jsp");
		} else {
			PlacesDB placesdb = new PlacesDB(); 
			placesdb.addPlace(new Place(pname));
			RequestDispatcher dispatcher = request.getRequestDispatcher("listPlaces");
			dispatcher.forward(request, response);
		}
	}

}
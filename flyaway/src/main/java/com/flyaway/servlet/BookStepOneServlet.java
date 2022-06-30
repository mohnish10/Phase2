package com.flyaway.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyaway.db.AirlinesDB;
import com.flyaway.db.PlacesDB;
import com.flyaway.model.Place;

/**
 * Servlet implementation class EnterFlightdataServlet
 */
@WebServlet("/bookStepOne")
public class BookStepOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookStepOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlacesDB placesdb = new PlacesDB(); 
		String message = request.getParameter("message");
		List<Place> places = placesdb.getAllPlaces();
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookStepOne.jsp");
		request.setAttribute("placelist", places);
		if (message != null) {
			request.setAttribute("message", message);
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
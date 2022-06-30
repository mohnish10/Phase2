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
import com.flyaway.db.FlightsDB;
import com.flyaway.db.PlacesDB;

/**
 * Servlet implementation class bookStepThree
 */
@WebServlet("/bookStepThree")
public class BookStepThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookStepThreeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FlightsDB flightsdb = new FlightsDB();
		PlacesDB placesdb = new PlacesDB();
		AirlinesDB airlinesdb = new AirlinesDB();
		RequestDispatcher dispatcher = request.getRequestDispatcher("bookStepThree.jsp");
		String flightIdString = request.getParameter("flightId");
		int flightId = Integer.parseInt(flightIdString);
		HttpSession session = request.getSession();
		int passengers = (Integer) session.getAttribute("passengers");
		//session.setAttribute("passengers", passengers);
		session.setAttribute("sourceName", placesdb.getPlaceById(flightsdb.getFlightById(flightId).getSourceId()).getPname());
		session.setAttribute("destinationName", placesdb.getPlaceById(flightsdb.getFlightById(flightId).getDestinationId()).getPname());
		session.setAttribute("airline", airlinesdb.getAirlineById(flightsdb.getFlightById(flightId).getAirlineId()).getAname());
		session.setAttribute("priceforone", flightsdb.getFlightById(flightId).getPrice());
		session.setAttribute("priceforall", flightsdb.getFlightById(flightId).getPrice()*passengers);
		session.setAttribute("flightid",flightId);
		dispatcher.forward(request, response);
	}

}
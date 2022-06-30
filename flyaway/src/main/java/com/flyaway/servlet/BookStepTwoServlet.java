package com.flyaway.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.flyaway.model.Flight;

/**
 * Servlet implementation class bookStepTwoServlet
 */
@WebServlet("/bookStepTwo")
public class BookStepTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookStepTwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post in step two");
		FlightsDB flightsdb = new FlightsDB();
		PlacesDB placesdb = new PlacesDB();
		AirlinesDB airlinesdb = new AirlinesDB();
		String sourceIdString = request.getParameter("sourceId");
		String dateString = request.getParameter("date");
		int sourceId = Integer.parseInt(sourceIdString);
		String destinationIdString = request.getParameter("destinationId");
		int destinationId = Integer.parseInt(destinationIdString);
		String destinationName = placesdb.getPlaceById(destinationId).getPname();
		String sourceName = placesdb.getPlaceById(sourceId).getPname();
		String passengersString = request.getParameter("passengers");
		int passengers = Integer.parseInt(passengersString);
		//save number of passengers in session variable
		HttpSession session = request.getSession();
		session.setAttribute("passengers", passengers);
		session.setAttribute("dateString", dateString);
		System.out.println("passengers: "+passengers+" date: "+dateString);
		List<Flight> flights = flightsdb.getAllFlightsBySourceIdAndDestinationId(sourceId, destinationId);
		System.out.println("number of flights found: "+flights.size());
		if (flights.size()==0) {
			response.sendRedirect("bookStepOne?message=no flights found between "+sourceName+" to "+destinationName);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("bookStepTwo.jsp");
			request.setAttribute("flightlist", flights);
			request.setAttribute("passengers", passengers);
			ArrayList<ArrayList<String>> flightsText = new  ArrayList<ArrayList<String>>();
			for (Flight flight:flights) {
				String flightId = Integer.toString(flight.getId());
				String sourceString = placesdb.getPlaceById(sourceId).getPname();
				String destinationString = placesdb.getPlaceById(destinationId).getPname();
				String airlineString = airlinesdb.getAirlineById(flight.getAirlineId()).getAname();
				String priceString = Double.toString(flight.getPrice());
				int priceForAll = (int) (flight.getPrice()*passengers);
				ArrayList<String> oneFlight = new ArrayList<String>();
				oneFlight.add(flightId);
				oneFlight.add(sourceString);
				oneFlight.add(destinationString);
				oneFlight.add(airlineString);
				oneFlight.add(priceString);
				oneFlight.add(Integer.toString(priceForAll));
				flightsText.add(oneFlight);
			}
			request.setAttribute("flightsText", flightsText);
			dispatcher.forward(request, response);
		}
	}

}
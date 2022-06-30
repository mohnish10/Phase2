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
import com.flyaway.model.Airline;
import com.flyaway.model.Flight;

/**
 * Servlet implementation class FlightActionServlet
 */
@WebServlet("/flightAction")
public class FlightActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightActionServlet() {
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
			FlightsDB flightsdb = new FlightsDB(); 
			if (action.equals("delete")) {
				flightsdb.deleteFlight(id);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("listFlights");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String sourceIdString = request.getParameter("sourceId");
		String destinationIdString = request.getParameter("destinationId");
		String airlineIdString = request.getParameter("airlineId");
		String priceString = request.getParameter("price");
		int sourceId = Integer.parseInt(sourceIdString);
		int destinationId = Integer.parseInt(destinationIdString);
		int airlineId = Integer.parseInt(airlineIdString);
		double price = Double.parseDouble(priceString);
		
		if(email == null) {
			response.sendRedirect("adminLogin.jsp");
		} else {
			FlightsDB flightsdb = new FlightsDB(); 
			flightsdb.addFlight(new Flight(sourceId, destinationId, airlineId, price));
			RequestDispatcher dispatcher = request.getRequestDispatcher("listFlights");
			dispatcher.forward(request, response);
		}
	}

}
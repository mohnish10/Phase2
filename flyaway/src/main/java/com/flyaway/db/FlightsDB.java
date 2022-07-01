package com.flyaway.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.flyaway.model.Flight;

public class FlightsDB {
	public List<Flight> getAllFlightsBySourceIdAndDestinationId(int sourceId, int destinationId)
	{
		List<Flight> flights = new ArrayList<Flight>();
		Connection con = MySQLConnection.getConnection();
		String sql = "select id, sourceId, destinationId, airlineId, price from flights where sourceId = ? and destinationId = ?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, sourceId);
			st.setInt(2, destinationId);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Flight flight = new Flight();
				flight.setId(rs.getInt(1));
				flight.setSourceId(rs.getInt(2));
				flight.setDestinationId(rs.getInt(3));
				flight.setAirlineId(rs.getInt(4));
				flight.setPrice(rs.getDouble(5));
				flights.add(flight);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flights;
	}
	
	public List<Flight> getAllFlights()
	{
		List<Flight> flights = new ArrayList<Flight>();
		Connection con = MySQLConnection.getConnection();
		String sql = "select id, sourceId, destinationId, airlineId, price from flights";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Flight flight = new Flight();
				flight.setId(rs.getInt(1));
				flight.setSourceId(rs.getInt(2));
				flight.setDestinationId(rs.getInt(3));
				flight.setAirlineId(rs.getInt(4));
				flight.setPrice(rs.getDouble(5));
				flights.add(flight);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flights;
	}
	
	public  boolean addFlight(Flight flight)
	{	
		String sql = "insert into flights (sourceId, destinationId, airlineId, price) values(?,?,?,?)";
		System.out.println("insert airline "+flight+" query: "+sql);
		Connection con = MySQLConnection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, flight.getSourceId());
			statement.setInt(2, flight.getDestinationId());
			statement.setInt(3, flight.getAirlineId());
			statement.setDouble(4, 	flight.getPrice());
			statement.execute();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return false;
		}
	
		return true;	
	}
	
	public  boolean deleteFlight(int id)
	{
		String sql = "delete from flights where id=?";
		Connection con = MySQLConnection.getConnection();
		try {
			
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			// kindly delete from loginuser table as well
			statement.execute();
			
		} catch (SQLException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	public Flight getFlightById(int id)
	{	
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from flights where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				Flight flight = new Flight();
				flight.setId(rs.getInt(1));
				flight.setSourceId(rs.getInt(2));
				flight.setDestinationId(rs.getInt(3));
				flight.setAirlineId(rs.getInt(4));
				flight.setPrice(rs.getDouble(5));
				return flight;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {	
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return null;
		
	}
}
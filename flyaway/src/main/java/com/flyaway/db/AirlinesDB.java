package com.flyaway.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flyaway.model.Airline;

public class AirlinesDB {
	public List<Airline> getAllAirlines()
	{
		List<Airline> airlines = new ArrayList<Airline>();
		Connection con = MySQLConnection.getConnection();
		String sql = "select id, aname from airlines";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Airline airline = new Airline();
				airline.setId(rs.getInt(1));
				airline.setAname(rs.getString(2));
				airlines.add(airline);
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
		return airlines;
		
	}
	
	public  boolean addAirline(Airline airline)
	{	
		String sql = "insert into airlines (aname) values(?)";
		System.out.println("insert airline "+airline+" query: "+sql);
		Connection con = MySQLConnection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, airline.getAname());
			statement.execute();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return false;
		}
	
		return true;	
	}

	public  boolean deleteAirline(int id)
	{
		String sql = "delete from airlines where id=?";
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
	
	public Airline getAirlineById(int id)
	{	
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from airlines where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				Airline airline = new Airline();
				airline.setId(rs.getInt(1));
				airline.setAname(rs.getString(2));
				return airline;
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
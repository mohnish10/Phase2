package com.flyaway.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flyaway.model.Airline;
import com.flyaway.model.Place;

public class PlacesDB {
	public List<Place> getAllPlaces()
	{
		List<Place> places = new ArrayList<Place>();
		Connection con = MySQLConnection.getConnection();
		String sql = "select id, pname from places";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Place place = new Place();
				place.setId(rs.getInt(1));
				place.setPname(rs.getString(2));
				places.add(place);
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
		return places;
		
	}
	
	public  boolean addPlace(Place place)
	{	
		String sql = "insert into places (pname) values(?)";
		System.out.println("insert place "+place+" query: "+sql);
		Connection con = MySQLConnection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, place.getPname());
			statement.execute();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return false;
		}
	
		return true;	
	}

	//it should be avoided deleting elements which are still referenced in flights table
	public  boolean deletePlace(int id)
	{
		String sql = "delete from places where id=?";
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
	
	public Place getPlaceById(int id)
	{	
		Connection con = MySQLConnection.getConnection();
		String sql = "select * from places where id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				Place place = new Place();
				place.setId(rs.getInt(1));
				place.setPname(rs.getString(2));
				return place;
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
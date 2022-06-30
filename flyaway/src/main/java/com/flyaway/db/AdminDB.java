package com.flyaway.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flyaway.model.Admin;

public class AdminDB {
	public boolean validateUser(Admin admin)
	{
		Connection con = MySQLConnection.getConnection();
		
		String sql = "select password from admin where email = ?";
		System.out.println("exexute query: "+sql);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, admin.getEmail());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				if(rs.getString(1).equals(admin.getPassword()))
					return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
	
	public  boolean updatePassword(Admin admin)
	{

		String sql = "update admin set password=? where email=?";
		
		Connection con = MySQLConnection.getConnection();
		
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, admin.getPassword());
			statement.setString(2, admin.getEmail());
			statement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		return true;	
	} 
}
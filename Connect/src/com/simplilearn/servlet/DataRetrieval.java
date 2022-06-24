package com.simplilearn.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataRetrieval 
{

	public static void main(String[] args) {

		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/ecommerce";
		String username="root";
		String password="@theultimateone1";

		try {
			//load the driver
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);

			if(conn!=null)
			{
				System.out.println("Connection Established");	
	String query = "select * from eproduct";
	PreparedStatement st = conn.prepareStatement(query);
	ResultSet rs = st.executeQuery();
	while(rs.next())
	{
	System.out.println(rs.getInt(1)+ " " +rs.getString("name")+ " " +rs.getBigDecimal(3)+ " " +rs.getTimestamp(4));
	}
			}
			else
System.out.println("Error while connecting with database");				
		}


catch(Exception e)
{
e.printStackTrace();	
}
		
	
	
	
	
	}	
}

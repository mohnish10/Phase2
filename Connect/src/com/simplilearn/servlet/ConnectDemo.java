package com.simplilearn.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDemo {

	public static void main(String[] args) throws SQLException {
		
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
			}
			else
				System.out.println("Error while connecting with Database");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

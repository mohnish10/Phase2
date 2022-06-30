package com.flyaway.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	
	/**
	 * 1) Download the driver(i.e jar file) from https://mvnrepository.com/artifact/mysql/mysql-connector-java
	 * 2) Add the jar file in the project class path
	 * 3) Load the driver using Class.forName
	 * 4) Provide connection parameters using DriverManager.getConnection()
	 * @return
	 */
	public static Connection getConnection()
	{
		
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			// mysql on windows : 3306
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway?autoReconnect=true&useSSL=false",
					"root", "@theultimateone1");
			System.out.println("DB Connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static Connection getConnection(String url, String driver, String username, String password)
	{
		
		Connection con = null;
		try {
			Class.forName(driver);
			System.out.println("Driver loaded");
			// mysql on windows : 3306
			con = DriverManager.getConnection(url, username, password);
					
			System.out.println("DB Connected with parameters from the context");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	

}
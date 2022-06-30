package com.simplilearn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataRetrieval {
	
public static void main(String[] args)
{
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/ecommerce";
	String username="root";
	String password="@theultimateone1";
	
	try
	{
	Class.forName(driver);	
	Connection conn = DriverManager.getConnection(url, username, password);
	
	if(conn!=null)
	{
	System.out.println("Connection established");
	String query = "select * from eproduct";
	PreparedStatement st = conn.prepareStatement(query);
	ResultSet result = st.executeQuery();
	while(result.next())
	{
	System.out.println(result.getInt("id")+ " " +result.getString("name")+ " "+result.getBigDecimal(3)+ " "+result.getTimestamp(4));
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

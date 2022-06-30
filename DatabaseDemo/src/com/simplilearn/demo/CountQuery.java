package com.simplilearn.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CountQuery {
	
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
String query = "select count(*) from eproduct";
PreparedStatement st = conn.prepareStatement(query);
ResultSet rs = st.executeQuery();
rs.next();
System.out.println("Count = " +rs.getInt(1));
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

package com.simplilearn.demo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DynamicQuery {
	
public static void main(String[] args)
{
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/ecommerce";
	String username="root";
	String password="@theultimateone1";
	Scanner sc = new Scanner(System.in);
System.out.println("Please enter the name of the laptop");
String name = sc.nextLine();
System.out.println("Please enter the price of the laptop");
BigDecimal price = sc.nextBigDecimal();

try
{
Class.forName(driver);
Connection conn = DriverManager.getConnection(url, username, password);
if(conn!=null)
{
System.out.println("Connection establised successfully");
String query = "insert into eproduct (name,price) values (?,?)";
PreparedStatement st = conn.prepareStatement(query);
st.setString(1, name);
st.setBigDecimal(2, price);
int x = st.executeUpdate();
if(x>0)
System.out.println("data is inserted into database");
else
System.out.println("Error while inserting data");	
}
else
System.out.println("Error while connecting to database");
}
catch(Exception e)
{
e.printStackTrace();	
}
}
}

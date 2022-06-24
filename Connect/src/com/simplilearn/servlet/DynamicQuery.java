package com.simplilearn.servlet;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DynamicQuery {
	
	public static void main(String[] args) {

		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/ecommerce";
		String username="root";
		String password="@theultimateone1";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Laptop name");
		String name = sc.nextLine();
		System.out.println("Enter Price");
		BigDecimal price = sc.nextBigDecimal();
		try
		{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);

			if(conn!=null)
			{
				System.out.println("Connection Established");
				String query = "insert into eproduct (name, price) values (?, ?)";
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, name);
				st.setBigDecimal(2, price);
				int x = st.executeUpdate();
				if(x>0)
				System.out.println("Data is inserted into database");
				else
				System.out.println("Error while inserting data");
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

package com.simplilearn.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dboperation")
public class DBOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
PrintWriter out = response.getWriter();
response.setContentType("text/html");


InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
Properties props = new Properties();
props.load(in);
Connection con = DBConfig.getConnection(props);
try
{
Statement st = con.createStatement();
int x = st.executeUpdate("create database demos");
if(x>0)
out.print("Database created sucessfully<br>");
else
out.print("Database already available<br>");
st.execute("use demos");
out.print("database selected <br>");
st.execute("drop database demos");
out.print("database dropped successfully");
}
catch(SQLException e)
{
e.printStackTrace();	
}	
}
	
	
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

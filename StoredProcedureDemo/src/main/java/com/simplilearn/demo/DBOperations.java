package com.simplilearn.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
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
response.setContentType("text/html");
PrintWriter out = response.getWriter();

InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
Properties props = new Properties();
props.load(in);
Connection con = DBConfig.getConnection(props);


try
{
Statement st = con.createStatement();
int x = st.executeUpdate("create database demos");
if(x>0)
out.print("database has been created successfully");
else
out.print("database already exist");	


st.execute("use demos");
out.print("Database selected<br>");
st.execute("drop database demos");
out.print("Database dropped successfully<br>");
}
catch(Exception e)
{
e.printStackTrace();	
}

	
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

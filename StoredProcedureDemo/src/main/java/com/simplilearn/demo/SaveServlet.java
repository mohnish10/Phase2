package com.simplilearn.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/save")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
PrintWriter out = response.getWriter();
response.setContentType("text/html");
String name = request.getParameter("pname");
BigDecimal price = new BigDecimal(request.getParameter("price"));

InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
Properties props = new Properties();
props.load(in);
Connection con = DBConfig.getConnection(props);

try
{
PreparedStatement pst = con.prepareCall("call add_product(?,?)");
pst.setString(1, name);
pst.setBigDecimal(2, price);
int x = pst.executeUpdate();
if(x>0)
out.print("Data has been inserted successfully");
else
out.print("Error while inserting data");
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

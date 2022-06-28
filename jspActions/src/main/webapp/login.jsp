<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("name");
String pass=request.getParameter("pass");


if(pass.equals("admin123"))
{
%>
<jsp:forward page="success.jsp">
<jsp:param value="<%=name %>" name="uname"/>
</jsp:forward> 
<% } else { %>
<h3>Wrong User name and password</h3>
<jsp:include page="index.jsp"/>
<% } %>
</body>
</html>
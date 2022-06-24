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
String name = request.getParameter("name");
String password = request.getParameter("password");
if(password.equalsIgnoreCase("admin@123")){ 
%>
<jsp:forward page="success.jsp">
<jsp:param value="<%=name%>" name="name"/>
</jsp:forward>
<% }else{%>
<h3>Wrong Username or password</h3>
<jsp:include page="index.html">
</jsp:include>
<%} %>
</body>
</html>
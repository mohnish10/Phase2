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
session.removeAttribute("uname");
session.invalidate();
%>
Successfully logged out...!!
<jsp:include page="index.html"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:usebean id="obj" class="com.simplilearn.demo.Student" scope="request">

<h3>Values before set</h3>
Roll No: <jsp:getProperty property="rollNo" name="obj"/> <br><br>
Name:    <jsp:getProperty property="name" name="obj"/> <br><br>


<jsp:setProperty property="rollNo" name="obj" value="20"/>
<jsp:setProperty property="name" name="obj" value="Alex"/>




</body>
</html>
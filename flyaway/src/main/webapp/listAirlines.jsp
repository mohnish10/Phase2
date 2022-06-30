<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
<%@include file="adminheader.html" %>
<div class='container'>
	<h2>Airlines</h2>
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Airline Name</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${airlinelist}" var="airline">
				<tr>
					<th scope="row">${airline.id }</th>
					<td>${airline.aname }</td>
					<td><a class="btn btn-primary" href="airlineAction?action=delete&id=${airline.id}" role="button">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<a class="btn btn-primary" href="addAirline.jsp" role="button">Add New Airline</a>
</body>
</html>
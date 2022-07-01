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
	<style>
		.error{
			color:red;
		}
	</style>
</head>
<body>
<%@include file="header.html" %>
<h1>Flight information summary:</h1>
<div class='container'>
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Source</th>
				<th scope="col">Destination</th>
				<th scope="col">Airline</th>
				<th scope="col">Price for one Passenger</th>
				<th scope="col">No. of Passengers</th>
				<th scope="col">Price for all Passengers</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td><c:out value="${dateString}"></c:out></td>
					<td><c:out value="${sourceName}"></c:out></td>
					<td><c:out value="${destinationName}"></c:out></td>
					<td><c:out value="${airline}"></c:out></td>
					<td><c:out value="${priceforone}"></c:out></td>
					<td><c:out value="${passengers}"></c:out></td>
					<td><c:out value="${priceforall}"></c:out></td>
				</tr>
		</tbody>
	</table>
</div>
	<div class='container'>
		<h1>Add Personal Info and payment </h1>

		<form action='bookLastStep' method=POST>
					<div class="form-group">
						<label for="username">Name:</label> <input type="text"
							class="form-control" id="name" placeholder="Enter your name please"
							name="name">
					</div>
					<br/>
					<div class="form-group">
						<label for="username">Street:</label> <input type="text"
							class="form-control" id="street" placeholder="street and number"
							name="street">
					</div>
					<br/>
					<div class="form-group">
						<label for="username">City:</label> <input type="text"
							class="form-control" id="airlineId" placeholder="city"
							name="city">
					</div>
					<br/>
					<div class="form-group">
						<label for="username">Credit Card Number:</label> <input type="text"
							class="form-control" id="ccno" placeholder="credit Card Number"
							name="ccno">
					</div>
					<br/>
			<button type="submit" class="btn btn-primary">Book Flight</button>
		</form>
	</div>
</body>
</html>
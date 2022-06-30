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
<div class='container'>
	<h2>Flights</h2>
	<h4>Number of passengers <c:out value="${passengers}"></c:out></h4>
	<h4>Date of Flight <c:out value="${dateString}"></c:out></h4>
	<form action="bookStepThree" method=POST>
	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col">select</th>
				<th scope="col">sourcePlaceId</th>
				<th scope="col">destinationPlaceId</th>
				<th scope="col">AirlineId</th>
				<th scope="col">Price per passenger</th>
				<th scope="col">Price for all passengers</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${flightsText}" var="flight">
				<tr>
					<td>
						<div class="form-check">
							<input class="form-check-input" type="radio" name="flightId" id="flexRadioDefault1" value="${flight[0]}">
							<label class="form-check-label" for="flexRadioDefault1">
							</label>
						</div>
					</td>
					<td>${flight[1]}</td>
					<td>${flight[2]}</td>
					<td>${flight[3]}</td>
					<td>${flight[4]}</td>
					<td>${flight[5]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type="submit" class="btn btn-primary">Next Step</button>
	</form>
</div>
</body>
</html>
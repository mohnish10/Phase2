<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%-- 
	they are included at compile time
	size of the file increases
	includes te content of the file as a part of this file
 --%>
<%@include file="adminheader.html" %>
	<div class='container'>
		<h1>Add Flight : </h1>

		<form action='flightAction' method=POST>
					<div class="form-group">
						<label for="username">From Id:</label> <input type="number"
							class="form-control" id="sourceId" placeholder="sourcePlaceId"
							name="sourceId">
					</div>
					<div class="form-group">
						<label for="username">To Id:</label> <input type="number"
							class="form-control" id="destinationId" placeholder="destinationPlaceId"
							name="destinationId">
					</div>
					<div class="form-group">
						<label for="username">Airline Id:</label> <input type="number"
							class="form-control" id="airlineId" placeholder="airline Id"
							name="airlineId">
					</div>
					<div class="form-group">
						<label for="username">Price:</label> <input type=""
							class="form-control" id="price" placeholder="priceperperson"
							name="price">
					</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>
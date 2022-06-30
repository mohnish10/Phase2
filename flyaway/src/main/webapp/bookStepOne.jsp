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

<!--  jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!-- Bootstrap Date-Picker Plugin -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />

</head>
<body>
<%@include file="header.html" %>
<div>
<%
	String message = request.getParameter("message");
	if(message != null){
	%>
	<span class='error'><%= message %></span>
	<%} 
%>
</div>
<form action='bookStepTwo' method=POST>
  <div class="form-group">
    <label for="exampleFormControlSelect1">Fly from:</label>
    <select class="form-control" id="exampleFormControlSelect1" name="sourceId">
       <c:forEach items="${placelist}" var="place">
       		<option value="${place.id }">${place.pname}</option>
       </c:forEach>		
    </select>
  </div>
  <br/>
   <div class="form-group">
    <label for="exampleFormControlSelect1">Fly to:</label>
    <select class="form-control" id="exampleFormControlSelect1" name="destinationId">
       <c:forEach items="${placelist}" var="place">
       		<option value="${place.id }">${place.pname}</option>
       </c:forEach>		
    </select>
  </div>
  <br/>
	<div class="form-group">
		<label for="username">Number of passangers</label> <input type="number"
		class="form-control" id="passengers" placeholder="number of passengers"
		name="passengers">
	</div>
	<br/>
	<div class="form-group">
		<!-- Date input -->
		<label class="control-label" for="date">Date</label> <input
		class="form-control" id="date" name="date"
		placeholder="MM/DD/YYY" type="text" />
	</div>
	<br/>
	<button type="submit" class="btn btn-primary">Next Step</button>
</form>
	<script type="text/javascript">
		$(document).ready(
				function() {
					var date_input = $('input[name="date"]'); //our date input has the name "date"
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					var options = {
						format : 'mm/dd/yyyy',
						container : container,
						todayHighlight : true,
						autoclose : true,
					};
					date_input.datepicker(options);
				})
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="id" value="${p.id}"></c:set>
<c:set var="name" value="${p.name}"></c:set>
<c:set var="price" value="${p.price}"></c:set>
<c:set var="quantity" value="${p.quantity}"></c:set>
<c:out value="${id}"></c:out>
<c:out value="${name}"></c:out>
<c:out value="${price}"></c:out>
<c:out value="${quantity}"></c:out>
</body>
</html>
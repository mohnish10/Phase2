<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="name" value="Simplilearn"></c:set>
<c:set var="name1" value="learn"></c:set>
Lowercase : ${fn:toLowerCase(name)}<br>
Uppercase : ${fn:toUpperCase(name)}<br>
<c:if test="${fn:contains(name,name1)}">
String contains the defined value<br>
</c:if>
<c:set var="str1" value="Hello Word Message"></c:set>
<c:set var="str2" value="${fn:split(str1,'')}"></c:set>
<c:set var="str3" value="${fn:join(str2,'-')}"></c:set>
Joined String:${str3}
Substring: ${fn:substring(name,0,6)}><br>
<h3>Iterations</h3>
<c:forEach items="${str1}" var="x">
<c:out value="${(fn:toUpperCase(x))}"></c:out><br>
</c:forEach>
</body>
</html>